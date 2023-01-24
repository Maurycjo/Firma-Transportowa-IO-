import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

import product.Product;
import product.ProductStorage;
import user.AUser;
import user.Client;
import user.Worker;

public class Main {
    public static AUser loggedUser;
    public static ArrayList<Client> clientList  = new ArrayList<>();
    public static ArrayList<Worker> workerList = new ArrayList<>();
    public static void main(String[] args) throws IllegalFormatCodePointException
    {
        ProductStorage storage = new ProductStorage();
        storage.addProductToStorage(new Product("Ziemniaki", "zime", 1000, 50));
        storage.addProductToStorage(new Product("cebula", "polska", 100, 34));
        storage.addProductToStorage(new Product("Chleb", "niewarzywo", 10, 500));

        clientList.add(new Client("Bartosz", "Jakis", storage));
        clientList.add(new Client("Joe", "Doe", storage));
        clientList.add(new Client("Parizad", "Uday", storage));

        workerList.add(new Worker("Bob", "Pracownik", storage));
        workerList.get(0).setClientList(clientList);

        //loggedUser = clientList.get(0);
        loggedUser = workerList.get(0);

        if(loggedUser instanceof Client){
            clientView((Client) loggedUser);
        } else if(loggedUser instanceof Worker) {
            workerView((Worker) loggedUser);
        }
    }

    public static void clientView(Client loggedClient) throws IllegalFormatCodePointException
    {
        loggedClient.displayOrders();
    }

    public static void workerView(Worker loggedWorker) throws IllegalFormatCodePointException
    {
        loggedWorker.displayClientList();
        loggedWorker.productStorage.showAllProducts();
    }
}