package net.comtor.undertow.lab;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;

/**
 *
 * @author juriel
 */
public class Main {

    public static void main(String[] args) {

        int PORT = 8080;
        if (System.getenv("PORT") != null) {
            Integer.parseInt(System.getenv("PORT"));
        }
        Undertow server = Undertow.builder()
                .addHttpListener(8080,"0.0.0.0")
                .setHandler(new HttpHandler() {
                    @Override
                    public void handleRequest(final HttpServerExchange exchange) throws Exception {
                        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
                        exchange.getResponseSender().send("Hello World");
                    }

                }).build();
        server.start();
    }
}
