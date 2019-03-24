package Interfaces;





public interface IOperations {
   
    void Save(String nome, int matricula, String area);
    void Delete(long id);
    void Update(Long id, String nome, int matricula, String area);
    void Consult();

}
