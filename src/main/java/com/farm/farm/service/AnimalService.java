package com.farm.farm.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.farm.farm.model.Animal;
import com.farm.farm.repository.AnimalRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AnimalService {
    // Centralizar la lógica de negocio
    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal findById(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal no encontrado con id: " + id));
    }

    public void deleteById(Long id) {
        animalRepository.deleteById(id);
    }

    public List<Animal> listarTodos() {
        return animalRepository.findAll();
    }

    public void guardar(Animal animal) {
        animalRepository.save(animal);
    }

    public void eliminar(Long id) {
        animalRepository.deleteById(id);
    }

    public List<Animal> buscarPorEspecie(String especie) {
        return animalRepository.findByEspecie(especie);
    }

    public List<Animal> buscarPorSexo(String sexo) {
        return animalRepository.findBySexo(sexo);
    }

    public List<String> listarUbicaciones() {
        return animalRepository.findDistinctUbicaciones();
    }

    // Contar todos los animales
    public long contarAnimales() {
        return animalRepository.contarAnimales();
    }

    // Contar embarazadas
    public long contarEmbarazadas() {
        return animalRepository.contarEmbarazadas();
    }

    // Contar heridos
    public long contarHeridos() {
        return animalRepository.contarHeridos();
    }

    // Calcular media de peso
    public double calcularMediaPeso() {
        return animalRepository.calcularMediaPeso();
    }

    // Contar animales por especie
    public Map<String, Long> contarAnimalesPorEspecie() {
        List<Animal> animales = animalRepository.findAll();
        return animales.stream()
                .collect(Collectors.groupingBy(Animal::getEspecie, Collectors.counting()));
    }

    // Contar animales por el estado de salud
    public Map<String, Long> contarAnimalesPorEstadoSalud() {
        return animalRepository.findAll().stream()
                .collect(Collectors.groupingBy(Animal::getEstadoSalud, Collectors.counting()));
    }


    // EXPORTACIONES DE DATOS
    public String exportToCSV() {
        List<Animal> animals = animalRepository.findAll();
        StringBuilder builder = new StringBuilder();
        builder.append(
                "ID,Nombre,Especie,Edad,Peso,FechaNacimiento,Sexo,Raza,EstadoSalud,FechaUltimaVacuna,TipoAlimento,Observaciones,Embarazada,Ubicacion,Emoji\n");

        for (Animal a : animals) {
            builder.append(a.getId()).append(",")
                    .append(a.getNombre()).append(",")
                    .append(a.getEspecie()).append(",")
                    .append(a.getEdad()).append(",")
                    .append(a.getPeso()).append(",")
                    .append(a.getFechaNacimiento()).append(",")
                    .append(a.getSexo()).append(",")
                    .append(a.getRaza()).append(",")
                    .append(a.getEstadoSalud()).append(",")
                    .append(a.getFechaUltimaVacuna()).append(",")
                    .append(a.getTipoAlimento()).append(",")
                    .append(a.getObservaciones()).append(",")
                    .append(a.isEmbarazada()).append(",")
                    .append(a.getUbicacion()).append(",")
                    .append(a.getEmoji()).append("\n");
        }

        return builder.toString();
    }

    public byte[] exportToExcel() throws IOException {
        List<Animal> animals = animalRepository.findAll();
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Animales");

            Row headerRow = sheet.createRow(0);
            String[] headers = {
                    "ID", "Nombre", "Especie", "Edad", "Peso", "FechaNacimiento", "Sexo",
                    "Raza", "EstadoSalud", "FechaUltimaVacuna", "TipoAlimento",
                    "Observaciones", "Embarazada", "Ubicacion", "Emoji"
            };

            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            int rowIdx = 1;
            for (Animal a : animals) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(a.getId());
                row.createCell(1).setCellValue(a.getNombre());
                row.createCell(2).setCellValue(a.getEspecie());
                row.createCell(3).setCellValue(a.getEdad());
                row.createCell(4).setCellValue(a.getPeso());
                row.createCell(5).setCellValue(a.getFechaNacimiento() != null ? a.getFechaNacimiento().toString() : "");
                row.createCell(6).setCellValue(a.getSexo() != null ? a.getSexo().toString() : "");
                row.createCell(7).setCellValue(a.getRaza());
                row.createCell(8).setCellValue(a.getEstadoSalud());
                row.createCell(9)
                        .setCellValue(a.getFechaUltimaVacuna() != null ? a.getFechaUltimaVacuna().toString() : "");
                row.createCell(10).setCellValue(a.getTipoAlimento());
                row.createCell(11).setCellValue(a.getObservaciones());
                row.createCell(12).setCellValue(a.isEmbarazada());
                row.createCell(13).setCellValue(a.getUbicacion() != null ? a.getUbicacion().toString() : "");
                row.createCell(14).setCellValue(a.getEmoji());
            }

            workbook.write(out);
            return out.toByteArray();
        }
    }

}
