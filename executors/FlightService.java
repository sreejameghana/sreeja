package com.codewithmosh.executors;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import static java.util.stream.Nodes.collect;

// get quote for a given flight from aganecy
public class FlightService {
// this methods gets the quote so do the method here
    // if it returns Quote then it is synchronous method we should do completable future of quote
// working on getting quotes from different websites  simple we want to get the quotes that means a list of quotes
    // get quotes should have th eknowledge of the websites you might query so giving the website and storing them in the sites lits of stringsd
   // to query and get the prices
        //    1. create a list of completable futures of quotes then iterate over the list of site get each site for each site get the getquote method and then add th result for our list
    // intermediate will not execute anything but will build a pipelien
    // evetually collect the result into a list object
    // chnaging the List<CompletableFuture<Quote>> to Stream<CompletableFuture<Quote>> to get the stream out of it
    public Stream<CompletableFuture<Quote>> getQuotes() {
        // thi smethod should have knowledge of the site we might query i will add the list of string to a variable
        var sites = List.of("site1", "site2", "site3");
        // we will use the streams api to iterate over the sites send them to quote to get the quote for each site
        return  sites.stream()
                 .map(this::getQuote);
                //.collect(Collectors.toList());// collecting quotes to the lost and returning since map is intermediate operation
                 //.collect(Collectors.toList());
              // .map(s->getQuote(s));
               // .map(s->getQuotes());// taking each site and calling the getquote methoid
    }
    public CompletableFuture<Quote> getQuote(String site) {


        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting a quote from"+ site);
            Random random = new Random();
            LongTask.simulate(1000 +random.nextInt(3000));// calling remote service will take time so simulationg that we are calling the site and this class odes that fro us

            int price = 100 + random.nextInt(10);
            return new Quote(site, price);
        });


    }
}


