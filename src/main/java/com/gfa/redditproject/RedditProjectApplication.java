package com.gfa.redditproject;

import com.gfa.redditproject.models.Post;
import com.gfa.redditproject.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedditProjectApplication implements CommandLineRunner {

	private final PostService postService;

	@Autowired
    public RedditProjectApplication(PostService postService) {
        this.postService = postService;
    }

    public static void main(String[] args) {
		SpringApplication.run(RedditProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		postService.save(new Post("Adventure Time Fan Club", "https://adventuretimefansite.com"));
		postService.save(new Post("Healthy Cooking Recipes", "https://healthyeatsrecipes.org"));
		postService.save(new Post("Tech Gadgets Review", "https://techgadgetreviews.com"));
		postService.save(new Post("Traveling on a Budget", "https://budgettraveler.com"));
		postService.save(new Post("DIY Home Improvement", "https://diyhomeprojects.net"));
		postService.save(new Post("Science Fiction Book Club", "https://scifibookclub.org"));
		postService.save(new Post("Vintage Vinyl Records", "https://vintagemusiccollector.com"));
		postService.save(new Post("Fitness Tips and Tricks", "https://fitnessexpertsadvice.com"));
		postService.save(new Post("Gourmet Coffee Lovers", "https://gourmetcoffeefans.com"));
		postService.save(new Post("Outdoor Camping Adventures", "https://campingadventures.net"));
		postService.save(new Post("Mindfulness Meditation Hub", "https://mindfulmeditationhub.org"));
		postService.save(new Post("Classic Movie Buffs", "https://classicfilmlovers.com"));
		postService.save(new Post("Pet Adoption Stories", "https://adoptapetstories.com"));
		postService.save(new Post("Artists Showcase Gallery", "https://artisticshowcasegallery.com"));
		postService.save(new Post("Video Game Strategies", "https://pro-gamerstrategies.net"));
		postService.save(new Post("Vintage Car Enthusiasts", "https://vintagecarscollector.com"));
		postService.save(new Post("Fashion Trends Insider", "https://fashiontrendsexpose.com"));
		postService.save(new Post("Sustainable Living Tips", "https://sustainablelifestyle.org"));
		postService.save(new Post("Photography Composition Guide", "https://photocompositiontips.com"));
		postService.save(new Post("Gardening for Beginners", "https://beginnergardenersguide.com"));
		postService.save(new Post("Futuristic Technology Innovations", "https://futuretechinnovations.com"));
		postService.save(new Post("Culinary Delights Around the World", "https://worldculinarydelights.org"));
		postService.save(new Post("DIY Crafty Creations", "https://diycraftycreations.net"));
		postService.save(new Post("Historical Mysteries Unveiled", "https://historicalmysteriesrevealed.com"));
		postService.save(new Post("Yoga and Wellness Retreats", "https://yogawellnessretreats.org"));
		postService.save(new Post("Wildlife Photography Wonders", "https://wildlifephotographywonders.com"));
		postService.save(new Post("Astrophysics Explorations", "https://astrophysicsexplorers.com"));
		postService.save(new Post("Vintage Fashion Finds", "https://vintagefashionhunt.com"));
		postService.save(new Post("Financial Freedom Strategies", "https://financialfreedomstrategies.net"));
		postService.save(new Post("Healthy Mindfulness Habits", "https://mindfulmindsethabits.com"));
		postService.save(new Post("Ultimate Car Racing Fanatics", "https://carracingfanatics.com"));
		postService.save(new Post("Eco-Friendly Living Tips", "https://ecolivingtipsandtricks.com"));
		postService.save(new Post("Anime Enthusiasts Community", "https://animefanscommunity.org"));
		postService.save(new Post("Science of Brain Health", "https://brainhealthscience.com"));
		postService.save(new Post("Modern Art Masterpieces", "https://modernartcollector.org"));
		postService.save(new Post("Fitness Challenges and Triumphs", "https://fitnesstriumphs.com"));
		postService.save(new Post("Travel Photography Journeys", "https://travelphotographyjourneys.net"));
		postService.save(new Post("Classic Literature Book Club", "https://classiclitbookclub.com"));
		postService.save(new Post("Home Decor DIY Inspirations", "https://homedecordiyinspo.com"));
		postService.save(new Post("Healthy Plant-Based Recipes", "https://plantbasedrecipeheaven.com"));

	}
}
