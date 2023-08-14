package com.example.coffeeapp.data.repositories

import com.example.coffeeapp.domain.model.CoffeeMakerModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class MockCoffeeMakersRepository : CoffeeMakersRepository {

    private val coffeeMakers: Flow<List<CoffeeMakerModel>> = flow {
        emit(
            listOf(
                CoffeeMakerModel(
                    1,
                    "Drip Coffee Makers (electric)",
                    "Traditionally, drip coffee makers have been a popular staple of American households due to a combination of ease of use, affordability, durability, and the ability to quickly produce coffee for one to four coffee drinkers at a time.\n" +
                            "\n" +
                            "Drip machines are one of the most popular types of coffee makers in the US.",
                    "https://coffeeaffection.com/wp-content/uploads/2019/04/Drip-coffee-maker.webp"
                ),
                CoffeeMakerModel(
                    2,
                    "Thermal Coffee Makers (electric)",
                    "Thermal coffee makers work like drip coffee brewers, but with the unique advantages of brewing your coffee into an insulated thermal carafe. This keeps your coffee hot for hours without continuing to “cook” your coffee as it sits on a heated surface, which can eventually lead to a thick and bitter brew.",
                    "https://coffeeaffection.com/wp-content/uploads/2019/04/Thermal-coffee-maker.webp"
                ),
                CoffeeMakerModel(
                    3,
                    "Espresso machines (electric)",
                    "One of the more expensive types of coffee makers is the electric espresso machine. While home espresso machines can cost a little more than other types of household brewers and can tend to be more finicky and labor-intense, it can be worth it to the die-hard espresso lover if you get your technique down pat and are able to successfully extract the rich, delicious shots of brew like your favorite coffee shop.",
                    "https://coffeeaffection.com/wp-content/uploads/2019/04/Espresso-machine.webp"
                ),
                CoffeeMakerModel(
                    4,
                    "Percolators (electric)",
                    "Percolators are fun to watch and to listen to as they steam away during the brewing process. They also tend to produce a consistently hearty and flavorful pot of coffee. Percolators were largely replaced by drip brewers in many households, probably due to having more parts to assemble and clean than drip brewers.",
                    "https://coffeeaffection.com/wp-content/uploads/2019/04/Percolator.webp"
                ),
                CoffeeMakerModel(
                    5,
                    "Siphon Coffee Makers (electric)",
                    "Siphon coffee makers, also known as vacuum pot coffee makers, may not be very practical for everyday use due to their many fragile parts and the unusual amount of time and labor that goes into brewing each pot. Many siphon pot users swear by the unusually great-tasting coffee that they produce. The siphon pot is also great as a showpiece when entertaining and brewing for houseguests.",
                    "https://coffeeaffection.com/wp-content/uploads/2019/04/Siphon-coffee-maker.webp"
                ),
                CoffeeMakerModel(
                    6,
                    "French Press Coffee Makers (manual)",
                    "The French press, also known as a “press pot” or “plunger pot,” is easy to use, easy to clean, and can even be taken with you when you travel. The press uses a mesh metal filter. This allows all the coffee’s flavor oils to make it into your cup, as opposed to getting trapped in a paper filter during brewing. Travel-friendly versions also exist.",
                    "https://coffeeaffection.com/wp-content/uploads/2019/04/French-press.webp"
                ),
                CoffeeMakerModel(
                    7,
                    "AeroPress (manual)",
                    "The AeroPress looks like a giant syringe and allows the user to make unusually smooth espresso-like coffees by hand without an expensive and cumbersome machine. The Aeropress is simple to use, easy to clean, and small enough to take with you on your travels.",
                    "https://coffeeaffection.com/wp-content/uploads/2019/04/AeroPress-1.webp"
                ),
                CoffeeMakerModel(
                    8,
                    "Cold Brew Coffee Makers (Manual)",
                    "The “Toddy” brand cold brew coffee maker is an easy and reliable brewer that consistently produces a uniquely delicious coffee concentrate that can be refrigerated for later use. Also known as “cold water extract,” cold brew coffee can be diluted and poured over ice or heated like regular coffee. It’s known for producing a less acidic brew than other types of devices.",
                    "https://coffeeaffection.com/wp-content/uploads/2019/04/Cold-brew-coffee-maker.webp"
                ),
                CoffeeMakerModel(
                    9,
                    "Vietnamese Coffee Makers (manual)",
                    "If you like your coffee sweet and cold over ice, this may be the coffee brewer for you. Vietnamese coffee typically includes the addition of condensed milk or cream and sugar to achieve the perfect cup of rich, sweet iced coffee.",
                    "https://coffeeaffection.com/wp-content/uploads/2019/04/Vietnamese-coffee-maker.webp"
                ),
                CoffeeMakerModel(
                    10,
                    "Moka Pot Coffee Makers (stovetop)",
                    "The Moka pot is a simple and cost-effective alternative to a full-blown home espresso machine. It produces a thick, rich and flavorful brew that goes great with creamers, flavored syrups or frothy steamed milk. The Moka pot is also a favorite brewing device for campers who enjoy brewing on a camping stove or over the fire. This type of coffee maker brews quickly and produces an espresso-like kind of coffee.",
                    "https://coffeeaffection.com/wp-content/uploads/2019/04/Moka-pot.webp"
                )
            )
        )
    }

    override suspend fun listCoffeeMakers(): Flow<List<CoffeeMakerModel>> {
        return coffeeMakers
    }
}