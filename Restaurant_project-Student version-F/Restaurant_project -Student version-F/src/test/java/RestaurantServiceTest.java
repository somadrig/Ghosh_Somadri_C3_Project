
import org.junit.jupiter.api.*;

import java.time.LocalTime;
import java.time.LocalDate;
import java.util.List;
//import org.hamcrest.MatcherAssert;
//import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;



import static org.junit.jupiter.api.Assertions.*;
//package src.main;
@ExtendWith({MockitoExtension.class})

class RestaurantServiceTest {

    RestaurantService service = new RestaurantService();
    Restaurant restaurant;
    LocalTime openingTime = LocalTime.parse("11:30:00");
    LocalTime closingTime = LocalTime.parse("21:00:00");

    @BeforeAll
    public static void beforeAll() {
        System.out.println("At BeforeAll");
        LocalTime openingTime = LocalTime.parse("11:30:00");
        LocalTime closingTime = LocalTime.parse("21:00:00");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("At afterAll");
    }

    @BeforeEach
    public void setup() {
        this.service = new RestaurantService();
        System.out.println("At beforeEach");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("At afterEach");
    }
    //Restaurant restaurantAdded = new Rastaurant();
    //REFACTOR ALL THE REPEATED LINES OF CODE
    //Restaurant restaurant = service.addRestaurant("Khan Chacha","MG Road",10,22);


    //>>>>>>>>>>>>>>>>>>>>>>SEARCHING<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void searching_for_existing_restaurant_should_return_expected_restaurant_object() throws restaurantNotFoundException {
        //WRITE UNIT TEST CASE HERE

        //assertEquals(1, restaurant.getName().size());
       // LocalTime openingTime = LocalTime.parse("11:30:00");
       // LocalTime closingTime = LocalTime.parse("21:00:00");
        restaurant = service.addRestaurant("Kings Restaurant","Mumbai",openingTime,closingTime);
        restaurant.addToMenu("Clear Lime Soup",119);
        restaurant.addToMenu("Manchow Soup", 269);

        //int initialNumberOfRestaurants = service.getRestaurants().size();
        //service.findRestaurantByName("Kings Restaurant");
        assertEquals(restaurant, service.findRestaurantByName("Kings Restaurant"));
    }

    //You may watch the video by Muthukumaran on how to write exceptions in Course 3: Testing and Version control: Optional content
    @Test
    public void searching_for_non_existing_restaurant_should_throw_exception() throws restaurantNotFoundException {
        //WRITE UNIT TEST CASE HERE
        //assertEquals(1, restaurant.getName().size());
       // LocalTime openingTime = LocalTime.parse("9:30:00");
       // LocalTime closingTime = LocalTime.parse("20:00:00");
        restaurant = service.addRestaurant("Devis Bar & Cafe","Kolkata",openingTime,closingTime);
        restaurant.addToMenu("Prawn Lime Soup",109);
        restaurant.addToMenu("Mix Veg Soup", 99);

        int initialNumberOfRestaurants = service.getRestaurants().size();
        service.findRestaurantByName("Amelie's cafe");
        assertEquals(restaurant, service.findRestaurantByName("Amelie's cafe"));
    }
    //<<<<<<<<<<<<<<<<<<<<SEARCHING>>>>>>>>>>>>>>>>>>>>>>>>>>




    //>>>>>>>>>>>>>>>>>>>>>>ADMIN: ADDING & REMOVING RESTAURANTS<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void remove_restaurant_should_reduce_list_of_restaurants_size_by_1() throws restaurantNotFoundException {
        //LocalTime openingTime = LocalTime.parse("10:30:00");
        //LocalTime closingTime = LocalTime.parse("22:00:00");
        restaurant = service.addRestaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);

        int initialNumberOfRestaurants = service.getRestaurants().size();
        service.removeRestaurant("Amelie's cafe");
        assertEquals(initialNumberOfRestaurants-1, service.getRestaurants().size());
    }

    @Test
    public void removing_restaurant_that_does_not_exist_should_throw_exception() throws restaurantNotFoundException {
        //LocalTime openingTime = LocalTime.parse("10:30:00");
        //LocalTime closingTime = LocalTime.parse("22:00:00");
        restaurant = service.addRestaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);

        assertThrows(restaurantNotFoundException.class,()->service.removeRestaurant("Pantry d'or"));
    }

    @Test
    public void add_restaurant_should_increase_list_of_restaurants_size_by_1(){
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        restaurant = service.addRestaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);

        int initialNumberOfRestaurants = service.getRestaurants().size();
        service.addRestaurant("Pumpkin Tales","Chennai",LocalTime.parse("12:00:00"),LocalTime.parse("23:00:00"));
        assertEquals(initialNumberOfRestaurants + 1,service.getRestaurants().size());
    }
    //<<<<<<<<<<<<<<<<<<<<ADMIN: ADDING & REMOVING RESTAURANTS>>>>>>>>>>>>>>>>>>>>>>>>>>
}