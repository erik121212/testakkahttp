package web;

import akka.actor.ActorSystem;
import akka.http.javadsl.server.HttpApp;
import akka.http.javadsl.server.Route;

import java.io.IOException;

//import akka.http.javadsl.model.ContentTypes;
//import akka.http.javadsl.model.MediaTypes;

public class TestAkkaHttp extends HttpApp  {

    public static void main(String[] args) throws IOException {
        // boot up server using the route as defined below
        ActorSystem system = ActorSystem.create();

        new TestAkkaHttp().bindRoute("localhost", 8080, system);
        System.out.println("Type RETURN to exit");
        System.in.read();
        system.shutdown();
    }

    @Override
    public Route createRoute() {
        return
            complete("De url was localhost:8080/test");
    }

}
