package com.example.ws.controller;

import com.example.ws.dto.DosyaDTO;
import com.example.ws.dto.MusteriDTO;
import com.example.ws.entity.Dosya;
import com.example.ws.entity.Musteri;
import com.example.ws.service.MusteriArsivlemeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;


@RestController
public class MusteriArsivlemeServiceRestController {

    MusteriArsivlemeService musteriArsivlemeService;

    @Autowired
    public MusteriArsivlemeServiceRestController(MusteriArsivlemeService musteriArsivlemeService) {
        this.musteriArsivlemeService = musteriArsivlemeService;
    }

    @Operation(description = "Database'e musteri ekler.")
    @PostMapping(value = "/musteriKaydet", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Musteri ekleme başarılı" , content = @Content(schema = @Schema(implementation = MusteriDTO.class), mediaType = MediaType.APPLICATION_JSON_UTF8_VALUE)),
            @ApiResponse(responseCode = "400", description = "Musteri ekleme başarısız", content = @Content(schema = @Schema(implementation = String.class), mediaType = MediaType.APPLICATION_JSON_UTF8_VALUE)) })
    public @ResponseBody ResponseEntity<Musteri> musteriKaydet(HttpServletRequest httpServletRequest,
                                         @RequestBody MusteriDTO musteriDTO){

        return new ResponseEntity<>(musteriArsivlemeService.musteriKaydet(musteriDTO), HttpStatus.OK) ;
    }

    @Operation(description = "Databaseden musteri siler.")
    @DeleteMapping(value = "/musteriSil/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Musteri silme başarılı" , content = @Content(schema = @Schema(implementation = MusteriDTO.class), mediaType = MediaType.APPLICATION_JSON_UTF8_VALUE)),
            @ApiResponse(responseCode = "400", description = "Musteri silme başarısız", content = @Content(schema = @Schema(implementation = String.class), mediaType = MediaType.APPLICATION_JSON_UTF8_VALUE)) })
    public @ResponseBody ResponseEntity<Boolean> musteriSil(@PathVariable Long id){

        return new ResponseEntity<>(musteriArsivlemeService.musteriSil(id), HttpStatus.OK) ;
    }

    @Operation(description = "Musterileri listeler.")
    @GetMapping(value = "/musterileriListele", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Musteri listeleme başarılı" , content = @Content(schema = @Schema(implementation = DosyaDTO.class), mediaType = MediaType.APPLICATION_JSON_UTF8_VALUE)),
            @ApiResponse(responseCode = "400", description = "Musteri listeleme başarısız", content = @Content(schema = @Schema(implementation = String.class), mediaType = MediaType.APPLICATION_JSON_UTF8_VALUE)) })
    public @ResponseBody ResponseEntity<List<Musteri>> musteriListele(HttpServletRequest httpServletRequest,
                                                             @RequestBody DosyaDTO dosyaDTO){

        return new ResponseEntity<>(musteriArsivlemeService.musterileriListele(), HttpStatus.OK) ;
    }

    @Operation(description = "Musteri gunceller.")
    @PutMapping(value = "/musteriGuncelle/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Musteri guncelleme başarılı" , content = @Content(schema = @Schema(implementation = DosyaDTO.class), mediaType = MediaType.APPLICATION_JSON_UTF8_VALUE)),
            @ApiResponse(responseCode = "400", description = "Musteri guncelleme başarısız", content = @Content(schema = @Schema(implementation = String.class), mediaType = MediaType.APPLICATION_JSON_UTF8_VALUE)) })
    public @ResponseBody ResponseEntity<Musteri> musteriGuncelle(@RequestBody MusteriDTO musteriDTO,@PathVariable Long id){

        return new ResponseEntity<>(musteriArsivlemeService.musteriGuncelle(musteriDTO,id), HttpStatus.OK) ;
    }

    @Operation(description = "Database'e dosya ekler.")
    @PostMapping(value = "/dosyaKaydet/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dosya ekleme başarılı" , content = @Content(schema = @Schema(implementation = DosyaDTO.class), mediaType = MediaType.APPLICATION_JSON_UTF8_VALUE)),
            @ApiResponse(responseCode = "400", description = "Dosya ekleme başarısız", content = @Content(schema = @Schema(implementation = String.class), mediaType = MediaType.APPLICATION_JSON_UTF8_VALUE)) })
    public @ResponseBody ResponseEntity<Dosya> dosyaKaydet(@RequestBody DosyaDTO dosyaDTO,@PathVariable Long id){

        return new ResponseEntity<>(musteriArsivlemeService.dosyaKaydet(dosyaDTO, id), HttpStatus.OK) ;
    }

    @Operation(description = "Databaseden dosya siler.")
    @DeleteMapping(value = "/dosyaSil/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dosya silme başarılı" , content = @Content(schema = @Schema(implementation = MusteriDTO.class), mediaType = MediaType.APPLICATION_JSON_UTF8_VALUE)),
            @ApiResponse(responseCode = "400", description = "Dosya silme başarısız", content = @Content(schema = @Schema(implementation = String.class), mediaType = MediaType.APPLICATION_JSON_UTF8_VALUE)) })
    public @ResponseBody ResponseEntity<Boolean> dosyaSil(@PathVariable Long id){

        return new ResponseEntity<>(musteriArsivlemeService.dosyaSil(id), HttpStatus.OK) ;
    }

    @Operation(description = "Dosyalari listeler.")
    @GetMapping(value = "/dosyalariListele/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dosya listeleme başarılı" , content = @Content(schema = @Schema(implementation = DosyaDTO.class), mediaType = MediaType.APPLICATION_JSON_UTF8_VALUE)),
            @ApiResponse(responseCode = "400", description = "Dosya listeleme başarısız", content = @Content(schema = @Schema(implementation = String.class), mediaType = MediaType.APPLICATION_JSON_UTF8_VALUE)) })
    public @ResponseBody ResponseEntity<Set<Dosya>> dosyalariListele(@PathVariable Long id){

        Musteri musteri = musteriArsivlemeService.dosyalariGetir(id);

        return new ResponseEntity<>(musteri.getMusteriDosyalari(), HttpStatus.OK) ;
    }

    @Operation(description = "Dosya gunceller.")
    @PutMapping(value = "/dosyaGuncelle/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dosya guncelleme başarılı" , content = @Content(schema = @Schema(implementation = DosyaDTO.class), mediaType = MediaType.APPLICATION_JSON_UTF8_VALUE)),
            @ApiResponse(responseCode = "400", description = "Dosya guncelleme başarısız", content = @Content(schema = @Schema(implementation = String.class), mediaType = MediaType.APPLICATION_JSON_UTF8_VALUE)) })
    public @ResponseBody ResponseEntity<Dosya> dosyaGuncelle(@RequestBody DosyaDTO dosyaDTO,@PathVariable Long id){

        return new ResponseEntity<>(musteriArsivlemeService.dosyaGuncelle(dosyaDTO,id), HttpStatus.OK) ;
    }

}