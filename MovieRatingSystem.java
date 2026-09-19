import java.util.Scanner;

public class MovieRatingSystem
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        String[] movieNames = new String[5];
        int[] ratings = new int[5];

        int totalRating = 0;
        boolean foundTen = false;
        boolean foundBelowFour = false;
        boolean allSevenOrHigher = true;
        boolean foundBelowThree = false;

        // Get the user's name
        System.out.print("Enter your name >> ");
        String userName = input.nextLine();

        System.out.println();
        System.out.println("Hello, " + userName + "!");

        // Get five movie names and ratings
        for (int i = 0; i < 5; i++)
        {
            System.out.println();
            System.out.print("Enter movie #" + (i + 1) + " >> ");
            movieNames[i] = input.nextLine();

            System.out.print("Rate " + movieNames[i] + " from 1 to 10 >> ");
            ratings[i] = input.nextInt();

            // Validate the rating
            while (ratings[i] < 1 || ratings[i] > 10)
            {
                System.out.print(
                    "Invalid rating. Enter a rating from 1 to 10 >> "
                );
                ratings[i] = input.nextInt();
            }

            input.nextLine();

            totalRating += ratings[i];

            if (ratings[i] == 10)
            {
                foundTen = true;
            }

            if (ratings[i] < 4)
            {
                foundBelowFour = true;
            }

            if (ratings[i] < 7)
            {
                allSevenOrHigher = false;
            }

            if (ratings[i] < 3)
            {
                foundBelowThree = true;
            }
        }

        // Calculate the average
        double average = (double) totalRating / ratings.length;

        System.out.println();
        System.out.println("Your average movie rating is " + average);

        // Classify the user's ratings
        if (average >= 9)
        {
            System.out.println("You are a cinephile!");
        }
        else if (average >= 7)
        {
            System.out.println("You enjoy movies quite a bit.");
        }
        else if (average >= 5)
        {
            System.out.println("You have mixed feelings about movies.");
        }
        else
        {
            System.out.println("You are a tough critic!");
        }

        // Check for masterpiece or poorly rated movie
        if (foundTen || foundBelowFour)
        {
            if (foundTen)
            {
                System.out.println("Wow! You found a masterpiece.");
            }

            if (foundBelowFour)
            {
                System.out.println("That movie didn't impress you much.");
            }
        }

        // Check rating consistency
        if (allSevenOrHigher && ratings.length == 5)
        {
            System.out.println("You seem to enjoy most movies.");
        }
        else if (foundBelowThree || average < 3)
        {
            System.out.println("You have strong opinions on movies!");
        }

        // Get favorite genre
        System.out.println();
        System.out.print(
            "Enter your favorite genre " +
            "(Action, Comedy, Horror, Drama, Sci-Fi) >> "
        );

        String genre = input.nextLine();

        // Respond based on genre
        switch (genre.toLowerCase())
        {
            case "action":
                System.out.println("You love excitement and thrills!");
                break;

            case "comedy":
                System.out.println("You enjoy a good laugh.");
                break;

            case "horror":
                System.out.println("You have a taste for fear!");
                break;

            case "drama":
                System.out.println("You appreciate deep storytelling.");
                break;

            case "sci-fi":
                System.out.println(
                    "You love futuristic and imaginative worlds!"
                );
                break;

            default:
                System.out.println("That's an interesting genre!");
                break;
        }

        // Recommend a movie using the conditional operator
        String recommendation =
            genre.equalsIgnoreCase("Sci-Fi")
                ? "Interstellar"
                : "The Dark Knight";

        System.out.println("Movie recommendation: " + recommendation);

        input.close();
    }
}
