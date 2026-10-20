import br.com.eliakim.dao.UserDAO;
import br.com.eliakim.model.MenuOpition;
import br.com.eliakim.model.UserModel;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Main {

    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        final UserDAO dao = new UserDAO();


        System.out.println("Bem-vindo ao cadastro de usuário.\n Selecione a opção desejada");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Atualiazar");
        System.out.println("3 - Excluir");
        System.out.println("4 - Buscar por Identificador");
        System.out.println("5 - Listar");
        System.out.println("6 - Sair");

        var userInput = sc.nextInt();
        while (true) {
            var selectedOption = MenuOpition.values()[userInput - 1];
            switch (selectedOption) {
                case SAVE -> {
                    var user = dao.save(requestToSave());
                    System.out.printf("Usuario cadastrado %f", user );
                }
                case UPDATE -> {
                   var user = dao.update(requestToUpdate());
                    System.out.printf("Usuario atualiazado %f", user );

                }
                case DETELE -> {
                   dao.delete(requestId());
                   System.out.println("Usuario deletado." );
                }
                case FIND_BY_ID -> {
                    var id = requestId();
                  var user = dao.findById(id);
                    System.out.printf("Usuario com id %s:",id);
                    System.out.println(user);
                }

                case FIND_ALL -> {
                    var users =  dao.findAll();
                    System.out.println("Usuários cadastrados");
                    users.forEach(System.out::println);

                }

                case EXIT -> System.exit(0);


            }
        }

    }

    private static UserModel requestToSave() {
        System.out.println("Informe o nome do Usuário");
        var name = sc.next();
        System.out.println("Informe o email");
        var email = sc.next();
        System.out.println("Informe a data de aniversário (dd/MM/yyyy)");
        var birthdayString = sc.next();
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday = OffsetDateTime.parse(birthdayString, formatter);
        return new UserModel(0L, name, birthday, email);

    }

    private static UserModel requestToUpdate() {
        System.out.println("Informe o indentificador do Usuário");
        var id = sc.nextLong();
        System.out.println("Informe o nome do Usuário");
        var name = sc.next();
        System.out.println("Informe o email");
        var email = sc.next();
        System.out.println("Informe a data de aniversário (dd/MM/yyyy)");
        var birthdayString = sc.next();
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday = OffsetDateTime.parse(birthdayString, formatter);
        return new UserModel(id, name, birthday, email);

    }

    private static long requestId(){
        System.out.println("Informe o indentificador do Usuário");
       return sc.nextLong();
    }
}