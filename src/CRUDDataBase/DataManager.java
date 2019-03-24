package CRUDDataBase;

import DBClasses.DataBaseClass;
import java.util.Scanner;

public class DataManager {

    private DataBaseClass dbc;
    private boolean isConnected;
    private Scanner sc;

    public DataManager(String usuario, String password) {
        DataBaseClass dbc = new DataBaseClass();
        //isConnected = dbc.ConnectDataBase("Thiago", "123");
        isConnected = dbc.ConnectDataBase(usuario, password);
    }

    public void Save() {
        if (!isConnected) {
            System.out.println("Não foi possivel a execução da instrução.");
            return;
        }

        String nome = sc.next();
        int matricula = sc.nextInt();
        String area = sc.next();
        dbc.Save(nome, matricula, area);

    }

    public void Delete() {
        if (!isConnected) {
            System.out.println("Não foi possivel a execução da instrução.");
            return;
        }

        long id = sc.nextLong();
        dbc.Delete(id);

    }

    public void Update() {
        if (!isConnected) {
            System.out.println("Não foi possivel a execução da instrução.");
            return;
        }
        String nome = sc.next();
        int matricula = sc.nextInt();
        String area = sc.next();
        long id = sc.nextLong();
        dbc.Update(id, nome, matricula, area);

    }

    public void Consult() {
        if (!isConnected) {
            System.out.println("Não foi possivel a execução da instrução.");
            return;
        }

        dbc.Consult();

    }

    public void CloseConection() {
        if (!isConnected) {
            System.out.println("Não foi possivel a execução da instrução.");
            return;
        }

    }

}
