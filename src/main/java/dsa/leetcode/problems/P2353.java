/*
2353. Design a Food Rating System
Medium

Design a food rating system that can do the following:

Modify the rating of a food item listed in the system.
Return the highest-rated food item for a type of cuisine in the system.
Implement the FoodRatings class:

FoodRatings(String[] foods, String[] cuisines, int[] ratings) Initializes the system. The food items are described by foods, cuisines and ratings, all of which have a length of n.
foods[i] is the name of the ith food,
cuisines[i] is the type of cuisine of the ith food, and
ratings[i] is the initial rating of the ith food.
void changeRating(String food, int newRating) Changes the rating of the food item with the name food.
String highestRated(String cuisine) Returns the name of the food item that has the highest rating for the given type of cuisine. If there is a tie, return the item with the lexicographically smaller name.
Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order, that is, either x is a prefix of y, or if i is the first position such that x[i] != y[i], then x[i] comes before y[i] in alphabetic order.



Example 1:

Input
["FoodRatings", "highestRated", "highestRated", "changeRating", "highestRated", "changeRating", "highestRated"]
[[["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", "greek", "japanese", "korean"], [9, 12, 8, 15, 14, 7]], ["korean"], ["japanese"], ["sushi", 16], ["japanese"], ["ramen", 16], ["japanese"]]
Output
[null, "kimchi", "ramen", null, "sushi", null, "ramen"]

Explanation
FoodRatings foodRatings = new FoodRatings(["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", "greek", "japanese", "korean"], [9, 12, 8, 15, 14, 7]);
foodRatings.highestRated("korean"); // return "kimchi"
                                    // "kimchi" is the highest rated korean food with a rating of 9.
foodRatings.highestRated("japanese"); // return "ramen"
                                      // "ramen" is the highest rated japanese food with a rating of 14.
foodRatings.changeRating("sushi", 16); // "sushi" now has a rating of 16.
foodRatings.highestRated("japanese"); // return "sushi"
                                      // "sushi" is the highest rated japanese food with a rating of 16.
foodRatings.changeRating("ramen", 16); // "ramen" now has a rating of 16.
foodRatings.highestRated("japanese"); // return "ramen"
                                      // Both "sushi" and "ramen" have a rating of 16.
                                      // However, "ramen" is lexicographically smaller than "sushi".


Constraints:

1 <= n <= 2 * 104
n == foods.length == cuisines.length == ratings.length
1 <= foods[i].length, cuisines[i].length <= 10
foods[i], cuisines[i] consist of lowercase English letters.
1 <= ratings[i] <= 108
All the strings in foods are distinct.
food will be the name of a food item in the system across all calls to changeRating.
cuisine will be a type of cuisine of at least one food item in the system across all calls to highestRated.
At most 2 * 104 calls in total will be made to changeRating and highestRated.
 */
package dsa.leetcode.problems;

import dsa.leetcode.problems.P2353.FoodRatings.Food;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

//TODO: copy paste the correct code
@Slf4j
public class P2353 {
    public class FoodRatings {
        String[] foods, cuisines;
        int[] ratings;

        @Builder
        @Data
        @NoArgsConstructor
        public static class Food {
            String food, cuisine;
            int rating;

            Food (String food, String cuisine, int rating) {
                this.rating = rating;
                this.food = food;
                this.cuisine = cuisine;
            }
        }
        Set<Food> foodSet;
        Map<String,Food> foodToFood;
        Map<String, Set<Food>> cuisineToFood;
        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            this.foods = foods;
            this.cuisines = cuisines;
            this.ratings = ratings;
            int n = ratings.length;
            this.foodSet = new TreeSet<>(((o1, o2) -> o2.rating - o1.rating ));
            this.cuisineToFood = new HashMap<>();
            this.foodToFood = new HashMap<>();
            for(int i = 0; i < n; i++) {
                Food food = new Food(foods[i], cuisines[i], ratings[i]);
                foodToFood.put(foods[i], food);
                Set<Food> sett;
                if(cuisineToFood.containsKey(cuisines[i])) {
                    sett = cuisineToFood.get(cuisines[i]);
                } else {
                    sett = new TreeSet<>(Comparator.comparing((o->o.food)));
                }
                sett.add(food);
                cuisineToFood.put(cuisines[i], sett);
            }
        }

        public void changeRating(String food, int newRating) {
            if(!foodToFood.containsKey(food)) {
                return;
            }
            Food foodObj = foodToFood.get(food);
            cuisineToFood.get(foodObj.cuisine).remove(foodObj);
            foodToFood.remove(food);
            foodObj.rating = newRating;
            foodToFood.put(food, foodObj);
            cuisineToFood.get(foodObj.cuisine).add(foodObj);
        }

        public String highestRated(String cuisine) {
            return cuisineToFood.get(cuisine).iterator().next().food;
        }
    }

    public static void main(String[] args) {
        TreeSet<Food> sett = new TreeSet<>(((o1, o2) -> o2.rating - o1.rating));
        sett.add(Food.builder().food("food2").cuisine("cuisine2").rating(2).build());
        sett.add(Food.builder().food("food1").cuisine("cuisine1").rating(1).build());
        sett.add(Food.builder().food("food3").cuisine("cuisine3").rating(3).build());
//        for(Food food : sett) {
//            log.info("food : {}", food);
//        }
        log.info("{}",sett.first().food);
    }

}
