package com.example.knowyourmillet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var currentMillet = 0
    val milletsName = arrayOf("Pearl Millet","Proso Millet","Finger Millet","Sorghum Millet","Foxtail Millet")
    val milletsDetails = arrayOf(
        "Pearl millet is the most widely grown type of millet. It has been grown in Africa and the Indian subcontinent since prehistoric times. The center of diversity, and suggested area of domestication, for the crop is in the Sahel zone of West Africa.",
        "Proso millet is a relative of foxtail millet, pearl millet, maize, and sorghum within the grass subfamily Panicoideae. While all of these crops use C4 photosynthesis, the others all employ the NADP-ME as their primary carbon shuttle pathway, while the primary C4 carbon shuttle in proso millet is the NAD-ME pathway.",
        "Eleusine coracana, or finger millet is an annual herbaceous plant widely grown as a cereal crop in the arid and semiarid areas in Africa and Asia. It is a tetraploid and self-pollinating species probably evolved from its wild relative Eleusine africana. Finger millet is native to the Ethiopian and Ugandan highlands.",
        "Sorghum bicolor, commonly called sorghum and also known as great millet, broomcorn, guinea corn, durra, imphee, jowar, or milo, is a grass species cultivated for its grain, which is used for food for humans, animal feed, and ethanol production.",
        "Foxtail millet, scientific name Setaria italica, is an annual grass grown for human food. It is the second-most widely planted species of millet, and the most grown millet species in Asia."
    )

    lateinit var image: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val milletName = findViewById<TextView>(R.id.milletName)
        val milletDetails = findViewById<TextView>(R.id.milletDetails)

        milletName.text = milletsName[0]
        milletDetails.text = milletsDetails[0]

        val prev = findViewById<ImageButton>(R.id.btnPrev)
        val next = findViewById<ImageButton>(R.id.btnNext)

        prev.setOnClickListener {
            val currentImageOfMillet = "pic$currentMillet"
            val idOfCurrentImage = this.resources.getIdentifier(currentImageOfMillet,"id",packageName)
            image = findViewById(idOfCurrentImage)
            image.alpha = 0f

            currentMillet = (currentMillet+1)%5
            val nextImageOfMillet = "pic$currentMillet"
            val idOfNextImage = this.resources.getIdentifier(nextImageOfMillet,"id",packageName)
            image = findViewById(idOfNextImage)
            image.alpha = 1f

            milletName.text = milletsName[currentMillet]
            milletDetails.text = milletsDetails[currentMillet]
        }

        next.setOnClickListener {
            val currentImageOfMillet = "pic$currentMillet"
            val idOfCurrentImage = this.resources.getIdentifier(currentImageOfMillet,"id",packageName)
            image = findViewById(idOfCurrentImage)
            image.alpha = 0f

            currentMillet = (5+currentMillet-1)%5
            val prevImageOfMillet = "pic$currentMillet"
            val idOfPrevImage = this.resources.getIdentifier(prevImageOfMillet,"id",packageName)
            image = findViewById(idOfPrevImage)
            image.alpha = 1f

            milletName.text = milletsName[currentMillet]
            milletDetails.text = milletsDetails[currentMillet]
        }

    }
}