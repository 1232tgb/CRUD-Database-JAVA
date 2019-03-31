package CRUDDataBase;

import DBClasses.DataBaseClass;
import InputClasses.DataInput;


public class DataManager {

    private DataBaseClass dbc;
    private boolean isConnected = false;

    public DataManager(String usuario, String password) {
        dbc = new DataBaseClass();
        isConnected = dbc.ConnectDataBase(usuario, password);
    }

    public void Save() {
        if (!isConnected) {
            System.out.println("Não foi possivel a execução da instrução.");
            return;
        }

        String nome = DataInput.GetText("Entre com o nome");
        int matricula = DataInput.GetNumber("Enter com a matricula");
        String area = DataInput.GetText("Entre com a area");
        dbc.Save(nome, matricula, area);

    }

    public void Delete() {
        if (!isConnected) {
            System.out.println("Não foi possivel a execução da instrução.");
            return;
        }

        long id = (long) DataInput.GetNumber("Entre com a Id");
        dbc.Delete(id);

    }

    public void Update() {
        if (!isConnected) {
            System.out.println("Não foi possivel a execução da instrução.");
            return;
        }
        String nome = DataInput.GetText("Entre com o nome");
        int matricula = DataInput.GetNumber("Enter com a matricula");
        String area = DataInput.GetText("Entre com a area");
        long id = (long) DataInput.GetNumber("Entre com a Id");
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
      dbc.CloseConection();
    }

}
