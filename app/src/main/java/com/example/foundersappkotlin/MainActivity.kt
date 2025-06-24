package com.example.foundersappkotlin

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var founderList: List<FounderDetails>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.founders_list)

        founderList = listOf(
            FounderDetails("Kutti Krishnan","Kutti Krishnan P C founded Bumberry in 2013 to introduce reusable cloth diapers to Indian families, aiming to reduce environmental waste caused by disposables. The brand focuses on eco-friendly, washable, and skin-safe diapering solutions that combine traditional practices with modern designs.",R.drawable.bumberry),
            FounderDetails("Andy Rubin","Andy Rubin co-founded Android Inc. with the vision of creating a free, open-source mobile operating system that could power a wide range of devices. His work led to the development of the Android OS, which was later acquired by Google and became the world’s most widely used smartphone platform.",R.drawable.android),
            FounderDetails("Melanie Perkins, Cliff Obrecht & Cameron Adams","Canva was co-founded by Melanie Perkins, Cliff Obrecht, and Cameron Adams to democratize design. Their intuitive web-based platform allows users with no prior graphic design experience to create stunning visuals, from presentations and posters to social media posts and more.",R.drawable.canva),
            FounderDetails("Mark Zuckerberg","Mark Zuckerberg launched Facebook in 2004 from his Harvard dorm room as a social network for college students. It quickly grew into a global platform that redefined how billions of people connect, share, and communicate online.",R.drawable.facebook),
            FounderDetails("Kevin Systrom & Mike Krieger","Kevin Systrom and Mike Krieger built Instagram to make mobile photo sharing fast, beautiful, and social. With its clean interface and powerful filters, it quickly became a cultural phenomenon before being acquired by Facebook in 2012.",R.drawable.instagram),
            FounderDetails("Reid Hoffman","Reid Hoffman founded LinkedIn in 2002 to transform how professionals connect, network, and build careers online. The platform became the world’s largest professional networking site, helping millions find jobs, share insights, and grow professionally.",R.drawable.linkedin),
            FounderDetails("Jensen Huang","Jensen Huang co-founded NVIDIA in 1993 with a focus on high-performance graphics processing. Under his leadership, NVIDIA became a pioneer in GPU technology and played a key role in revolutionizing fields like gaming, AI, and deep learning.",R.drawable.nvidia),
            FounderDetails("Jack Dorsey, Biz Stone & Evan Williams","Originally conceived as a platform for sharing short status updates, Twitter was co-founded by Jack Dorsey, Biz Stone, and Evan Williams. It evolved into a real-time information network shaping news, culture, and public discourse — and was later rebranded to \"X\" under Elon Musk’s ownership.",R.drawable.twitterx),
            FounderDetails("Bill Gates","Bill Gates, co-founder of Microsoft, introduced Windows as a graphical operating system to make personal computing more accessible. The platform revolutionized the software industry and became the backbone of PC computing for decades.",R.drawable.windows),
            FounderDetails("Larry Page & Sergey Brin","Larry Page and Sergey Brin founded Google in 1998 as a research project at Stanford University. Their mission was to organize the world’s information and make it universally accessible. Today, Google powers billions of searches daily and is the foundation of one of the world’s largest tech ecosystems.",R.drawable.google)
        )

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = RVAdapter(this, founderList)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}