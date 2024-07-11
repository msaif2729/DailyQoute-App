package com.example.qoutes;



import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Vector;

public class ShowAlert {

    Context context;
    private MaterialCardView card1,card2,card3,card4,card5,card6;
    ImageView img1,img2,img3,img4,img5,img6;

    private SessionMaintain sessionMaintain;
    private ArrayList<Integer> imageResource;

    String[] themetypes={"Plain","Aesthetic","Nature","Cities","White And Black","Minimalism"};
    String[] Nature = {"nature1","nature2","nature3","nature4","nature5","nature6"};
    String[] Mimimalism = {"minimal1","minimal2","minimal3","minimal4","minimal5","minimal6"};

    String[] Cities = {"cities1","cities2","cities3","cities4","cities5","cities6"};
    String[] White = {"white1","white2","white3","white4","white5","white6"};
    String[] Aesthetic = {"aesthetic1","aesthetic2","aesthetic3","aesthetic4","aesthetic5","aesthetic6"};
    public ShowAlert(Context context) {
        this.context = context;
    }

    public void showalert(String message,LayoutInflater inflater)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = inflater.inflate(R.layout.themealert,null);
        card1 = view.findViewById(R.id.card1);
        card2 = view.findViewById(R.id.card2);
        card3 = view.findViewById(R.id.card3);
        card4 = view.findViewById(R.id.card4);
        card5 = view.findViewById(R.id.card5);
        card6 = view.findViewById(R.id.card6);
        img1 = view.findViewById(R.id.img1);
        img2 = view.findViewById(R.id.img2);
        img3 = view.findViewById(R.id.img3);
        img4 = view.findViewById(R.id.img4);
        img5 = view.findViewById(R.id.img5);
        img6 = view.findViewById(R.id.img6);
        imageResource = new ArrayList<>();
        for(String theme:themetypes)
        {
            if(message.equals(theme))
            {
//                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                switch (theme) {
                    case "Nature":
                        for(int i =0; i<Nature.length;i++)
                        {
//                            imageResource.clear();
                            imageResource.add(context.getResources().getIdentifier(Nature[i], "drawable", context.getPackageName()));
                        }
                        img1.setImageResource(imageResource.get(0));
                        img2.setImageResource(imageResource.get(1));
                        img3.setImageResource(imageResource.get(2));
                        img4.setImageResource(imageResource.get(3));
                        img5.setImageResource(imageResource.get(4));
                        img6.setImageResource(imageResource.get(5));
                        img1.setTag(Nature[0]);
                        img2.setTag(Nature[1]);
                        img3.setTag(Nature[2]);
                        img4.setTag(Nature[3]);
                        img5.setTag(Nature[4]);
                        img6.setTag(Nature[5]);
                        break;
                    case "Minimalism":
                        for(int i =0; i<Mimimalism.length;i++)
                        {
//                            imageResource.clear();
                            imageResource.add(context.getResources().getIdentifier(Mimimalism[i], "drawable", context.getPackageName()));
                        }
                        img1.setImageResource(imageResource.get(0));
                        img2.setImageResource(imageResource.get(1));
                        img3.setImageResource(imageResource.get(2));
                        img4.setImageResource(imageResource.get(3));
                        img5.setImageResource(imageResource.get(4));
                        img6.setImageResource(imageResource.get(5));
                        img1.setTag(Mimimalism[0]);
                        img2.setTag(Mimimalism[1]);
                        img3.setTag(Mimimalism[2]);
                        img4.setTag(Mimimalism[3]);
                        img5.setTag(Mimimalism[4]);
                        img6.setTag(Mimimalism[5]);
                        break;
                    case "Plain":
                        img1.setImageResource(R.color.pink);
                        img2.setImageResource(R.color.purple);
                        img3.setImageResource(R.color.blue);
                        img4.setImageResource(R.color.cream);
                        img5.setImageResource(R.color.bottlegreen);
                        img6.setImageResource(R.color.yellow);
                        img1.setTag("pink");
                        img2.setTag("purple");
                        img3.setTag("blue");
                        img4.setTag("cream");
                        img5.setTag("bottlegreen");
                        img6.setTag("yellow");
                        break;
                    case "Cities":
                        for(int i =0; i<Cities.length;i++)
                        {
//                            imageResource.clear();
                            imageResource.add(context.getResources().getIdentifier(Cities[i], "drawable", context.getPackageName()));
                        }
                        img1.setImageResource(imageResource.get(0));
                        img2.setImageResource(imageResource.get(1));
                        img3.setImageResource(imageResource.get(2));
                        img4.setImageResource(imageResource.get(3));
                        img5.setImageResource(imageResource.get(4));
                        img6.setImageResource(imageResource.get(5));
                        img1.setTag(Cities[0]);
                        img2.setTag(Cities[1]);
                        img3.setTag(Cities[2]);
                        img4.setTag(Cities[3]);
                        img5.setTag(Cities[4]);
                        img6.setTag(Cities[5]);
                        break;
                    case "Aesthetic":
                        for(int i =0; i<Aesthetic.length;i++)
                        {
//                            imageResource.clear();
                            imageResource.add(context.getResources().getIdentifier(Aesthetic[i], "drawable", context.getPackageName()));
                        }
                        img1.setImageResource(imageResource.get(0));
                        img2.setImageResource(imageResource.get(1));
                        img3.setImageResource(imageResource.get(2));
                        img4.setImageResource(imageResource.get(3));
                        img5.setImageResource(imageResource.get(4));
                        img6.setImageResource(imageResource.get(5));
                        img1.setTag(Aesthetic[0]);
                        img2.setTag(Aesthetic[1]);
                        img3.setTag(Aesthetic[2]);
                        img4.setTag(Aesthetic[3]);
                        img5.setTag(Aesthetic[4]);
                        img6.setTag(Aesthetic[5]);
                        break;
                    case "White":
                        for(int i =0; i<White.length;i++)
                        {
//                            imageResource.clear();
                            imageResource.add(context.getResources().getIdentifier(White[i], "drawable", context.getPackageName()));
                        }
                        img1.setImageResource(imageResource.get(0));
                        img2.setImageResource(imageResource.get(1));
                        img3.setImageResource(imageResource.get(2));
                        img4.setImageResource(imageResource.get(3));
                        img5.setImageResource(imageResource.get(4));
                        img6.setImageResource(imageResource.get(5));
                        img1.setTag(White[0]);
                        img2.setTag(White[1]);
                        img3.setTag(White[2]);
                        img4.setTag(White[3]);
                        img5.setTag(White[4]);
                        img6.setTag(White[5]);
                        break;
                    default: break;
                }
            }
        }

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectthemes(view);
            }
        });card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectthemes(view);
            }
        });card3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            selectthemes(view);
        }
        });card4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            selectthemes(view);
        }
        });card5.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            selectthemes(view);
        }
        });card6.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            selectthemes(view);
        }
        });
        sessionMaintain = new SessionMaintain(context);
        builder.setView(view)
                .setTitle(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick
                            (DialogInterface dialog, int which) {
                        if(card1.isChecked()||card2.isChecked()||card3.isChecked()||card4.isChecked()||card5.isChecked()||card6.isChecked())
                        {

                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .show();

    }

    public void selectthemes(View v)
    {

        if (v.getId() == R.id.card1) {
            card1.setChecked(!card1.isChecked());
            card2.setChecked(false);
            card3.setChecked(false);
            card4.setChecked(false);
            card5.setChecked(false);
            card6.setChecked(false);
            sessionMaintain.themesession(img1.getTag().toString());
        } else if (v.getId() == R.id.card2) {
            card2.setChecked(!card2.isChecked());
            card1.setChecked(false);
            card3.setChecked(false);
            card4.setChecked(false);
            card5.setChecked(false);
            card6.setChecked(false);
            sessionMaintain.themesession(img2.getTag().toString());
        } else if (v.getId() == R.id.card3) {
            card3.setChecked(!card3.isChecked());
            card2.setChecked(false);
            card1.setChecked(false);
            card4.setChecked(false);
            card5.setChecked(false);
            card6.setChecked(false);
            sessionMaintain.themesession(img3.getTag().toString());
        } else if (v.getId() == R.id.card4) {
            card4.setChecked(!card4.isChecked());
            card2.setChecked(false);
            card3.setChecked(false);
            card1.setChecked(false);
            card5.setChecked(false);
            card6.setChecked(false);
            sessionMaintain.themesession(img4.getTag().toString());
        } else if (v.getId() == R.id.card5) {
            card5.setChecked(!card5.isChecked());
            card2.setChecked(false);
            card3.setChecked(false);
            card4.setChecked(false);
            card1.setChecked(false);
            card6.setChecked(false);
            sessionMaintain.themesession(img5.getTag().toString());
        } else if (v.getId() == R.id.card6) {
            card6.setChecked(!card6.isChecked());
            card2.setChecked(false);
            card3.setChecked(false);
            card4.setChecked(false);
            card5.setChecked(false);
            card1.setChecked(false);
            sessionMaintain.themesession(img6.getTag().toString());
        }
    }

}
