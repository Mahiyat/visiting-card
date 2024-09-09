package com.example.idcard;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Gmail Icon
        ImageView gmailIcon = findViewById(R.id.imgGmail);
        gmailIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"mahiyat.stu2019@juniv.edu"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Test Email");
                intent.putExtra(Intent.EXTRA_TEXT, "Hi! How are you?");

                intent.setPackage("com.google.android.gm");

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Intent chooser = Intent.createChooser(intent, "Send Email");
                    if (chooser.resolveActivity(getPackageManager()) != null) {
                        startActivity(chooser);
                    } else {
                        Toast.makeText(MainActivity.this, "No email clients are installed.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Phone Icon
        ImageView phoneIcon = findViewById(R.id.imgPhone);
        phoneIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:01728714400"));
                startActivity(intent);
            }
        });

        // Facebook Icon
        ImageView facebookIcon = findViewById(R.id.imgFacebook);
        facebookIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String facebookId = "mahiyat.mahiyat.902";

                Intent intent = new Intent(Intent.ACTION_VIEW);

                // Try to open the Facebook app
                intent.setData(Uri.parse("fb://page/" + facebookId));

                if (!(intent.resolveActivity(getPackageManager()) == null)) {
                    startActivity(intent);
                } else {
                    intent.setData(Uri.parse("https://www.facebook.com/" + facebookId));
                    startActivity(intent);
                }
            }
        });

        // WhatsApp Icon
        ImageView whatsAppIcon = findViewById(R.id.imgWhatsApp);
        whatsAppIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://wa.me/+8801728714400"));
                startActivity(intent);
            }
        });

        ImageView telegramIcon = findViewById(R.id.imgTelegram);
        telegramIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://t.me/mahiyattanzim"));
                intent.setPackage("org.telegram.messenger");

                if (!(intent.resolveActivity(getPackageManager()) == null)) {
                    startActivity(intent);
                } else {
                    Intent fallbackIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/mahiyattanzim"));
                    startActivity(fallbackIntent);
                }
            }
        });

        // LinkedIn Icon
        ImageView linkedInIcon = findViewById(R.id.imgLinkedIn);
        linkedInIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/mahiyat-tanzim-168539206/"));
                startActivity(intent);
            }
        });

        // GitHub Icon
        ImageView gitHubIcon = findViewById(R.id.imgGitHub);
        gitHubIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Mahiyat"));
                startActivity(intent);
            }
        });

        // Portfolio Icon
        ImageView portfolioIcon = findViewById(R.id.imgPortfolio);
        portfolioIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mahiyat.github.io/"));
                startActivity(intent);
            }
        });
    }
}