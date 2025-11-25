package hotel;

import java.util.*;
import java.time.*;

/**
 * @author radum
 */
public class Hotel {

    // crear Scanner
    static Scanner sc = new Scanner(System.in);

    static boolean exitProgram = false;
    static int estadaCount = 0;

    static ArrayList<Client> clients = new ArrayList();
    static ArrayList<Habitacio> habitacions = new ArrayList();
    static ArrayList<Servei> serveis = new ArrayList();
    static ArrayList<Estada> estades = new ArrayList();

    public static void main(String[] args) {
        // crear serveis predeterminats
        Servei Bugaderia = new Servei("Bugaderia", 10);
        Servei Esmorzar = new Servei("Esmorzar", 11);
        Servei Dinar = new Servei("Dinar", 20);
        Servei Sopar = new Servei("Sopar", 18);

        serveis.add(Bugaderia);
        serveis.add(Esmorzar);
        serveis.add(Dinar);
        serveis.add(Sopar);

        // comencament del programa.
        while (!exitProgram) {
            System.out.println("  ");
            System.out.println("1. Alta nou client");
            System.out.println("2. Llistar clients");
            System.out.println("3. Modificar client");
            System.out.println("4. Afegir nova Habitacio");
            System.out.println("5. Llistar habitacions");
            System.out.println("6. Modificar habitacio");
            System.out.println("7. Afegir nou servei");
            System.out.println("8. Llistar serveis");
            System.out.println("9. Modificar servei");
            System.out.println("10. Afegir estada");
            System.out.println("11. Llistar estades");
            System.out.println("12. Fer servir estada");
            System.out.println("13. Sortir");
            System.out.print("input: ");

            int action = sc.nextInt();

            System.out.println("  ");

            switch (action) {
                case 1:
                    addClient();
                    break;
                case 2:
                    listClient();
                    break;
                case 3:
                    modClient();
                    break;
                case 4:
                    addHab();
                    break;
                case 5:
                    listHab();
                    break;
                case 6:
                    modHab();
                    break;
                case 7:
                    addServei();
                    break;
                case 8:
                    listServei();
                    break;
                case 9:
                    modServei();
                    break;
                case 10:
                    addEstada();
                    break;
                case 11:
                    listEstada();
                    break;
                case 12:
                    useEstada();
                    break;
                case 13:
                    exit();
                    break;
                default:
                    System.out.println("Introduiex una opcio correcte.");
                    break;
            }
        }
    }

    static void addClient() {
        System.out.print("Nom: ");
        String cliName = sc.next();
        System.out.print("NIF: ");
        String cliNif = sc.next();
        System.out.print("Data Naixament (YYYY MM DD): ");
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();
        clients.add(new Client(cliName, cliNif, LocalDate.of(year, month, day)));
        System.out.println("Client afegit a la base de dades...");
    }

    static void listClient() {
        for (int i = 0; i < clients.size(); i++) {
            System.out.println("Client " + i + ". " + clients.get(i).showData());
        }
    }

    static void modClient() {
        System.out.println("Quin client vols modificar?");
        listClient();
        System.out.print("input: ");
        int clientChoose = sc.nextInt();
        boolean modClientExitFields = false;
        while (!modClientExitFields) {
            System.out.println("Client seleccionat -> " + clients.get(clientChoose).showData());
            System.out.println("Quin camp vols modificar");
            System.out.println("1. Nom");
            System.out.println("2. NIF");
            System.out.println("3. Data Naixament");
            System.out.println("4. Borrar ");
            System.out.println("5. Sortir ");
            System.out.print("input: ");
            int modCliOption = sc.nextInt();
            switch (modCliOption) {
                case 1:
                    System.out.print("nom: ");
                    String cliNewName = sc.next();
                    clients.get(clientChoose).setNom(cliNewName);
                    break;
                case 2:
                    System.out.print("nom: ");
                    String cliNewNif = sc.next();
                    clients.get(clientChoose).setNif(cliNewNif);
                    break;
                case 3:
                    System.out.print("Data Naixament (YYYY MM DD): ");
                    int year = sc.nextInt();
                    int month = sc.nextInt();
                    int day = sc.nextInt();
                    clients.get(clientChoose).setDataNeix(LocalDate.of(year, month, day));
                    break;
                case 4:
                    clients.remove(clientChoose);
                    System.out.println("Client Borrat.");
                    modClientExitFields = true;
                    break;
                case 5:
                    modClientExitFields = true;
                    break;
                default:
                    System.out.println("Introduiex una opcio correcte.");
                    break;
            }
        }
    }

    static void addHab() {
        System.out.print("Planta: ");
        int habPlanta = sc.nextInt();
        boolean habExist = false;
        int habNumero = 0;
        while (!habExist) {
            habExist = true;
            System.out.print("Num habitacio: ");
            habNumero = sc.nextInt();
            for (int i = 0; i < habitacions.size(); i++) {
                if (habitacions.get(i).getPlanta() == habPlanta && habitacions.get(i).getNumero() == habNumero) {
                    habExist = false;
                    System.out.println("Ja existeix aquesta planta.");
                }
            }
        }

        System.out.print("Preu habitacio: ");
        double habPreu = sc.nextDouble();
        habitacions.add(new Habitacio(habPlanta, habNumero, habPreu));
        System.out.println("Habitacio afegida a la base de dades...");
    }

    static void listHab() {
        for (int i = 0; i < habitacions.size(); i++) {
            System.out.println("Habitacio " + i + ". " + habitacions.get(i).showData());
        }
    }

    static void listHabEstada() {
        for (int i = 0; i < habitacions.size(); i++) {
            if (habitacions.get(i).isOcupada() == false) {
                System.out.println("Habitacio " + i + ". " + habitacions.get(i).showData());
            }
        }
    }

    static void modHab() {
        System.out.println("Quina habitacio vols modificar?");
        listHab();
        System.out.print("input: ");
        int habChoose = sc.nextInt();
        boolean modHabExitFields = false;
        while (!modHabExitFields) {
            System.out.println("Habitacio seleccionada -> " + habitacions.get(habChoose).showData());
            System.out.println("Quin camp vols modificar");
            System.out.println("1. Planta");
            System.out.println("2. Numero");
            System.out.println("3. Preu");
            System.out.println("4. Ocupada");
            System.out.println("5. Borrar ");
            System.out.println("6. exit ");
            System.out.print("input: ");
            int modHabOption = sc.nextInt();
            switch (modHabOption) {
                case 1:
                    System.out.print("Planta: ");
                    int habNewFloor = sc.nextInt();
                    habitacions.get(habChoose).setPlanta(habNewFloor);
                    break;
                case 2:
                    System.out.print("Numero: ");
                    int habNewNumber = 0;
                    boolean habExist = false;
                    while (!habExist) {
                        habExist = true;
                        System.out.print("Num habitacio: ");
                        habNewNumber = sc.nextInt();
                        for (int i = 0; i < habitacions.size(); i++) {
                            if (habitacions.get(i).getPlanta() == habitacions.get(habChoose).getPlanta() && habitacions.get(i).getNumero() == habNewNumber) {
                                habExist = false;
                                System.out.println("Ja existeix aquesta planta.");
                            }
                        }
                    }
                    habitacions.get(habChoose).setNumero(habNewNumber);
                    break;
                case 3:
                    System.out.print("Preu: ");
                    int habNewPrice = sc.nextInt();
                    habitacions.get(habChoose).setPreuNit(habNewPrice);
                    break;
                case 4:
                    System.out.print("Ocupada: ");
                    boolean habNewStatus = sc.nextBoolean();
                    habitacions.get(habChoose).setOcupada(habNewStatus);
                    break;
                case 5:
                    habitacions.remove(habChoose);
                    System.out.println("Habitacio borrada.");
                    modHabExitFields = true;
                    break;
                case 6:
                    modHabExitFields = true;
                    break;
                default:
                    System.out.println("Introduiex una opcio correcte.");
                    break;
            }
        }
    }

    static void addServei() {
        System.out.print("Nom: ");
        String serveiName = sc.next();
        System.out.print("Preu: ");
        int serveiPreu = sc.nextInt();
        serveis.add(new Servei(serveiName, serveiPreu));
        System.out.println("Servei afegit a la base de dades...");
    }

    static void listServei() {
        for (int i = 0; i < serveis.size(); i++) {
            System.out.println("Servei " + i + ". " + serveis.get(i).showData());
        }
    }

    static void modServei() {
        System.out.println("Quin servei vols modificar?");
        listServei();
        System.out.print("input: ");
        int serveiChoose = sc.nextInt();
        boolean modServeiExitFields = false;
        while (!modServeiExitFields) {
            System.out.println("Servei seleccionat -> " + serveis.get(serveiChoose).showData());
            System.out.println("Quin camp vols modificar");
            System.out.println("1. Nom");
            System.out.println("2. Preu");
            System.out.println("3. Borrar");
            System.out.println("4. Sortir");
            System.out.print("input: ");
            int modCliOption = sc.nextInt();
            switch (modCliOption) {
                case 1:
                    System.out.print("Nom: ");
                    String serveiNewName = sc.next();
                    serveis.get(serveiChoose).setNom(serveiNewName);
                    break;
                case 2:
                    System.out.print("Preu: ");
                    int serveiNewPreu = sc.nextInt();
                    serveis.get(serveiChoose).setPreu(serveiNewPreu);
                    break;
                case 3:
                    serveis.remove(serveiChoose);
                    System.out.println("Servei borrat.");
                    modServeiExitFields = true;
                    break;
                case 4:
                    modServeiExitFields = true;
                    break;
                default:
                    System.out.println("Introduiex una opcio correcte.");
                    break;
            }
        }
    }

    static void addEstada() {
        estadaCount++;
        // crear estada selecionant un client, habitacio i els serveis que vol el client
        estades.add(new Estada(estadaCount));
        listClient();
        System.out.print("Escull el client: ");
        int clientChosen = sc.nextInt();
        estades.getLast().addClientTOArray(clientChosen); // . add (number of client oin array list)
        listHabEstada();
        System.out.print("Escull l'habitacio: ");
        int habChosen = sc.nextInt();
        estades.getLast().addHabTOArray(habChosen);
        // ocupar l'habitacio 
        habitacions.get(habChosen).setOcupada(true);
        System.out.println("Serveis: ");
        listServei();
        boolean serveiChosenEnd = false;
        while (!serveiChosenEnd) {
            System.out.print("Escull els serveis (-1 per sortir): ");
            int serveiChosen = sc.nextInt();
            if (serveiChosen == -1) {
                serveiChosenEnd = true;
            } else {
                // add serveice to estada
                estades.getLast().addServeiTOArray(serveiChosen);
                //list all services added 
                for (int i = 0; i < estades.getLast().getServeiEstada().size(); i++) {
                    System.out.println("- " + serveis.get(estades.getLast().getServeiEstada().get(i)).showData());
                }
            }
        }
        System.out.println("Estada creada.");
    }

    static void listEstada() {
        for (int i = 0; i < estades.size(); i++) {
            System.out.println("Estada " + i + ". " + estades.get(i).showDetails());
            System.out.println("Client estacionat: " + clients.get(estades.get(i).getClientEstada().get(0)).showData());
            System.out.println("Habitacio: " + habitacions.get(estades.get(i).getHabitacioEstada().get(0)).showData());
            System.out.println("Serveis: ");
            for (int j = 0; j < estades.get(i).getServeiEstada().size(); j++) {
                System.out.println(serveis.get(estades.get(i).getServeiEstada().get(j)).showData());
            }
            if (estades.get(i).getFacturaFinal() != 0) {
                System.out.println("Factura final: " + estades.get(i).getFacturaFinal() + " euros.");
            }
            System.out.println(" ");
        }
    }

    static void useEstada() {
        listEstada();
        System.out.print("Escull quina estada vols fer servir: ");
        int triarEstada = sc.nextInt();
        // ensenyar tots els serveis -> afegir els serveis a serveis utilitzats
        // consultar import -> mirar els serveis utilitzats i mirar el import de cada un i ensenyarlos
        // checkout i calcular factura final -> mostrar els serveis utilitzars, dies passats i IVA
        boolean estadaEnd = false;
        while (!estadaEnd) {
            System.out.println(" ");
            System.out.println("Opcions: ");
            System.out.println("1. fer servir servei");
            System.out.println("2. consultar import ");
            System.out.println("3. checkout");
            System.out.println("4. sortir");
            System.out.print("input: ");
            int action = sc.nextInt();
            System.out.println(" ");
            switch (action) {
                case 1:
                    estadaServeis(triarEstada);
                    break;
                case 2:
                    estadaImport(triarEstada);
                    break;
                case 3:
                    estadaCheckout(triarEstada);
                    break;
                case 4:
                    estadaEnd = true;
                    break;
                default:
                    System.out.println("");
                    break;
            }
        }

    }

    static void estadaServeis(int triarEstada) {
        System.out.println("Serveis: ");
        for (int j = 0; j < estades.get(triarEstada).getServeiEstada().size(); j++) {
            System.out.println(j + ". " + serveis.get(estades.get(triarEstada).getServeiEstada().get(j)).showData());
        }
        boolean usingServiceEnd = false;
        while (!usingServiceEnd) {
            System.out.print("Fer servir un servei (-1 per sortir): ");
            int estadaServeiUtilitzar = sc.nextInt();
            if (estadaServeiUtilitzar == -1) {
                usingServiceEnd = true;
            } else {
                estades.get(triarEstada).addUsedService(estadaServeiUtilitzar);
                double inportVell = estades.get(triarEstada).getImportActual();
                double inportServei = serveis.get(estades.get(triarEstada).getServeiEstada().get(estadaServeiUtilitzar)).getPreu();
                estades.get(triarEstada).setImportActual(inportVell + inportServei);
            }
        }
    }

    static void estadaImport(int triarEstada) {
        System.out.println("Import actual: " + estades.get(triarEstada).getImportActual() + " euros.");
    }

    static void estadaCheckout(int triarEstada) {
        System.out.println(" ");
        System.out.println("Data d'entrada " + estades.get(triarEstada).getDataEntrada());
        System.out.print("Afegeix la data de sortida (YYYY MM DD): ");                
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();
        estades.get(triarEstada).setDataSortida(LocalDate.of(year, month, day));
        int diesPassats = estades.get(triarEstada).getDataSortida().getDayOfMonth() - estades.get(triarEstada).getDataEntrada().getDayOfMonth();
        // show serveices
        System.out.println("Serveis utilitzats: ");
        for (int i = 0; i < estades.get(triarEstada).getServeisUtilitzats().size(); i++) {
            System.out.println("Servei. " + serveis.get(estades.get(triarEstada).getServeisUtilitzats().get(i)).showData());
        }
        double importDies = habitacions.get(estades.get(triarEstada).getHabitacioEstada().get(0)).getPreuNit() * diesPassats;
        estades.get(triarEstada).setImportActual(estades.get(triarEstada).getImportActual() + importDies);
        estades.get(triarEstada).setFacturaFinal(estades.get(triarEstada).getImportActual() * 1.16);
        System.out.println("Preu sense IVA: " + estades.get(triarEstada).getImportActual() + " euros");
        System.out.println("Factura Final: " + estades.get(triarEstada).getFacturaFinal() + " euros");
        habitacions.get(estades.get(triarEstada).getHabitacioEstada().get(0)).setOcupada(false);
        System.out.println(" ");

    }

    static void exit() {
        System.out.println("Exiting...");
        exitProgram = true;
    }

}
