package com.bu2.nam.weatherAPI.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bu2.nam.weatherAPI.modelDTO.CityDTO;
import com.bu2.nam.weatherAPI.modelDTO.CityExcellExport;
import com.bu2.nam.weatherAPI.modelDTO.CityPdfExport;
import com.bu2.nam.weatherAPI.modelDTO.ResponseDTO;
import com.bu2.nam.weatherAPI.modelDTO.SearchDTO;
import com.bu2.nam.weatherAPI.service.CityService;
import com.bu2.nam.weatherAPI.utils.DateTimeUtils;
import com.lowagie.text.DocumentException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = -1)
public class WeatherCityControllerAPI {
	@Autowired
	private CityService cityService;

	// add
	@PostMapping("/weather/add")
	public ResponseEntity<String> addWeather(@RequestBody CityDTO cityDTO)  {
		// ok

		try {
			cityService.add(cityDTO);
			return ResponseEntity.status(HttpStatus.OK).body("Them thanh cong");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Them that bai");
		}

	}

	// search
	@PostMapping("/weather/search")
	ResponseEntity<ResponseDTO<CityDTO>> getListCity(@RequestBody SearchDTO searchDTO) {

		String cityName = searchDTO.getName();
		String ApiKey = "e04ab634d63c387b7e7e4493b9515e52";
		String uri = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + ApiKey;

		
		RestTemplate restTemplate = new RestTemplate();

		List<CityDTO> cityDTOs = cityService.findCity(searchDTO);
		ResponseDTO<CityDTO> responseDTO = new ResponseDTO<>();

		if (cityDTOs.isEmpty()) {

			CityDTO cityDTO = restTemplate.getForObject(uri, CityDTO.class);
			Date date = new Date();
			cityDTO.setCreatedDate(DateTimeUtils.formatDate(date, DateTimeUtils.DD_MM_YYYY_HH_MM));
			
			cityDTOs.add(cityDTO);
			responseDTO.setData(cityDTOs);

		} else {

			responseDTO.setData(cityDTOs);
		}

		return new ResponseEntity<>(responseDTO, HttpStatus.OK);

	}

	// delete
	@GetMapping("/weather/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		try {
			cityService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body("Xoa thanh cong");
		} catch (Exception ex) {
			return new ResponseEntity<>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//getBy ID city
	@GetMapping("/weather/getById/{id}")
	public ResponseEntity<CityDTO> getById(@PathVariable("id") Long id) {

		CityDTO cityDTO = cityService.getById(id);
		if (cityDTO != null) {
			return new ResponseEntity<>(cityDTO, HttpStatus.OK);
		}
		return null;
	}

	// update
	@PostMapping("/weather/update")
	public ResponseEntity<String> update(@RequestBody CityDTO cityDTO) {

		try {
			cityService.update(cityDTO);
			return ResponseEntity.status(HttpStatus.OK).body("Update thanh cong");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// export PDF
	@GetMapping("/weather/export-pdf")
	public void exportToPdf(HttpServletResponse response) throws DocumentException, IOException {
		// trả về định dạng pdf
		response.setContentType("application/pdf");

		// cấu hình-đặt tên file
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String saveDate = dateFormat.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=weather_" + saveDate + ".pdf";
		response.setHeader(headerKey, headerValue);

		// lấy dữ liệu từ database-- get all data
		SearchDTO searchDTO = new SearchDTO();
		searchDTO.setName(" ");
		List<CityDTO> citys = cityService.findCity(searchDTO);

		// export
		CityPdfExport cityPdfExport = new CityPdfExport(citys);
		cityPdfExport.export(response);

	}

	// export Excell
	@GetMapping("/weather/export-excell")
	public void exportToExcell(HttpServletResponse response) throws IOException {
		// trả về định dạng excell
		response.setContentType("application/octet-stream");

		// cấu hình-đặt tên file
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String saveDate = dateFormat.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=weather_" + saveDate + ".xlsx";
		response.setHeader(headerKey, headerValue);

		// lấy dữ liệu từ database-- get all data
		SearchDTO searchDTO = new SearchDTO();
		searchDTO.setName(" ");

		List<CityDTO> citys = cityService.findCity(searchDTO);
		CityExcellExport cityExcellExport = new CityExcellExport(citys);
		cityExcellExport.export(response);

	}
}
