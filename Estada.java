package hotel;

import java.time.*;
import java.util.*;

/**
 * @author radum
 */
public class Estada {

    private int idEstada;
    private ArrayList<Integer> clientEstada = new ArrayList();
    private ArrayList<Integer> habitacioEstada = new ArrayList();
    private ArrayList<Integer> serveiEstada = new ArrayList();
    private LocalDate dataEntrada;
    private LocalTime horaEntrada;
    private LocalDate dataSortida;
    private LocalTime horaSortida;
    private double importActual;
    private double facturaFinal = 0.00;
    private ArrayList<Integer> serveisUtilitzats = new ArrayList();

    public Estada(int idEstada, LocalDate dataEntrada, LocalTime horaEntrada, LocalDate dataSortida, LocalTime horaSortida, double importActual, double facturaFinal) {
        this.idEstada = idEstada;
        this.dataEntrada = dataEntrada;
        this.horaEntrada = horaEntrada;
        this.dataSortida = dataSortida;
        this.horaSortida = horaSortida;
        this.importActual = importActual;
        this.facturaFinal = facturaFinal;
    }

    public Estada(int idEstada) {
        this.idEstada = idEstada;
        this.dataEntrada = LocalDate.now();
        this.horaEntrada = LocalTime.now();
        this.importActual = 0;
    }

    public int getIdEstada() {
        return idEstada;
    }

    public ArrayList<Integer> getClientEstada() {
        return clientEstada;
    }

    public ArrayList<Integer> getHabitacioEstada() {
        return habitacioEstada;
    }

    public ArrayList<Integer> getServeiEstada() {
        return serveiEstada;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalDate getDataSortida() {
        return dataSortida;
    }

    public LocalTime getHoraSortida() {
        return horaSortida;
    }

    public double getImportActual() {
        return importActual;
    }

    public double getFacturaFinal() {
        return facturaFinal;
    }

    public ArrayList<Integer> getServeisUtilitzats() {
        return serveisUtilitzats;
    }

    public void setIdEstada(int idEstada) {
        this.idEstada = idEstada;
    }

    public void setClientEstada(ArrayList<Integer> clientEstada) {
        this.clientEstada = clientEstada;
    }

    public void setHabitacioEstada(ArrayList<Integer> habitacioEstada) {
        this.habitacioEstada = habitacioEstada;
    }

    public void setServeiEstada(ArrayList<Integer> serveiEstada) {
        this.serveiEstada = serveiEstada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public void setDataSortida(LocalDate dataSortida) {
        this.dataSortida = dataSortida;
    }

    public void setHoraSortida(LocalTime horaSortida) {
        this.horaSortida = horaSortida;
    }

    public void setImportActual(double importActual) {
        this.importActual = importActual;
    }

    public void setFacturaFinal(double facturaFinal) {
        this.facturaFinal = facturaFinal;
    }

    public void setServeisUtilitzats(ArrayList<Integer> serveisUtilitzats) {
        this.serveisUtilitzats = serveisUtilitzats;
    }

    public void addClientTOArray(int numArrayCli) {
        clientEstada.add(numArrayCli);
    }

    public void addHabTOArray(int numArrayHab) {
        habitacioEstada.add(numArrayHab);
    }

    public void addServeiTOArray(int numArrayServei) {
        serveiEstada.add(numArrayServei);
    }
    
    public void addUsedService(int usedService){
        serveisUtilitzats.add(usedService);
    }
    
    public String showDetails(){
        return "data entrada: " + dataEntrada + ", hora entrada: " + horaEntrada + ", import actual: "+ importActual + ". ";
    }
}
