package cat.urv.deim.asm.p3.shared;

import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import cat.urv.deim.asm.libraries.commanagerdc.models.Article;
import cat.urv.deim.asm.libraries.commanagerdc.models.CalendarItem;
import cat.urv.deim.asm.libraries.commanagerdc.models.Event;
import cat.urv.deim.asm.libraries.commanagerdc.models.Faq;
import cat.urv.deim.asm.libraries.commanagerdc.models.New;
import cat.urv.deim.asm.libraries.commanagerdc.models.Tag;
import cat.urv.deim.asm.libraries.commanagerdc.providers.DataProvider;
import cat.urv.deim.asm.p2.common.R;


public class Faqs extends AppCompatActivity {


    private static final String TAG = Faqs.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs);

        expandableListView = findViewById(R.id.eListView);

        showList();

        listViewAdapter = new ExpandableListViewAdapter(this, listaPreguntas, listaRespuestas);
        expandableListView.setAdapter(listViewAdapter);

        DataProvider dataProvider;
        //Load data from synthetic origin
        dataProvider = DataProvider.getInstance(this.getApplicationContext());

        //Override wrapper that's allows to load data from any resource in raw directory of the project
        //dataProvider = DataProvider.getInstance(this.getApplicationContext(),R.raw.faqs,R.raw.news,R.raw.articles,R.raw.events,R.raw.calendar);

        List<? extends List> dataLists = new LinkedList<>();
        try {
            Object dataArray[]= {
                    dataProvider.getFaqs(),
                    dataProvider.getNews(),
                    dataProvider.getArticles(),
                    dataProvider.getEvents(),
                    dataProvider.getCalendar()
            };
            for (Object obj:dataArray){
                ArrayList<Object> list = (ArrayList<Object>) obj;

                Log.d(TAG,""+list.get(0).getClass().getSimpleName());

                if (list.get(0).getClass() == Faq.class){
                    showFaq((Faq) list.get(0));
                }else if(list.get(0).getClass() == New.class){
                    showNew((New) list.get(0));
                }else if(list.get(0).getClass() == Article.class){
                    showArticle((Article)list.get(0));
                }else if(list.get(0).getClass() == Event.class){
                    showEvent((Event) list.get(0));
                }else if(list.get(0).getClass() == CalendarItem.class){
                    showCalendar((CalendarItem) list.get(0));
                }else{
                    Log.e(TAG,"Type not supported");
                }





            }

        }
        catch (NullPointerException exception){
            Log.e(TAG,"Error accessing data");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        showImage((ImageView)findViewById(R.id.detail_image_view));
    }

    protected void showImage(ImageView view){

        DataProvider dataProvider = DataProvider.getInstance(this);
        int articleIndex = 0;
        String imageURL = dataProvider.getArticles().get(articleIndex).getImageURL();
        Picasso.get().load(imageURL).placeholder(R.drawable.ic_launcher_background).into(view);


    }

    protected void showFaq(Faq faq){
        Log.d(TAG,"Field Body:"+faq.getBody());
        Log.d(TAG,"Field Title:"+faq.getTitle());
    }

    protected void showArticle(Article article){
        Log.d(TAG,"Field Author:"+article.getAuthor());
        Log.d(TAG,"Field Date:"+article.getDate());
        Log.d(TAG,"Field DateUpdate:"+article.getDateUpdate());
        Log.d(TAG,"Field Title:"+article.getTitle());
        Log.d(TAG,"Field AbstractText:"+article.getAbstractText());
        Log.d(TAG,"Field Text:"+article.getText());
        Log.d(TAG,"Field Description:"+article.getDescription());
        Log.d(TAG,"Field ImageURL:"+article.getImageURL());
        Log.d(TAG,"Field Tags:");
        for (Tag tag:article.getTags()){
            Log.d(TAG,"Field Tags:"+tag.getName());
        }
    }

    protected void showNew(New newItem){
        Log.d(TAG,"Field Title:"+newItem.getTitle());
        Log.d(TAG,"Field Subtitle:"+newItem.getSubtitle());
        Log.d(TAG,"Field Text:"+newItem.getText());
        Log.d(TAG,"Field Date:"+newItem.getDate());
        Log.d(TAG,"Field DateUpdate:"+newItem.getDateUpdate());
        Log.d(TAG,"Field ImageURL:"+newItem.getImageURL());
        Log.d(TAG,"Field Tags:");
        for (Tag tag:newItem.getTags()){
            Log.d(TAG,"Field Tags:"+tag.getName());
        }

    }

    protected void showEvent(Event event){
        Log.d(TAG,"Field Name:"+event.getName());
        Log.d(TAG,"Field Description:"+event.getDescription());
        Log.d(TAG,"Field Type:"+event.getType());
        Log.d(TAG,"Field Tags:"+event.getTags());
        Log.d(TAG,"Field webURL:"+event.getWebURL());
        Log.d(TAG,"Field ImageURL:"+event.getImageURL());
        Log.d(TAG,"Field Tags:");
        for (Tag tag:event.getTags()){
            Log.d(TAG,"Field Tags:"+tag.getName());
        }
    }

    protected void showCalendar(CalendarItem calendar){
        Log.d(TAG,"Field Name:"+calendar.getName());
        Log.d(TAG,"Field Descripció:"+calendar.getDescription());
        Log.d(TAG,"Field Venue:"+calendar.getVenue());
        Log.d(TAG,"Field Date:"+calendar.getDate());
        Log.d(TAG,"Field Hour:"+calendar.getHour());
        Log.d(TAG,"Field ImageURL:"+calendar.getImageURL());
        Log.d(TAG,"Field Tags:");
        for (Tag tag:calendar.getTags()){
            Log.d(TAG,"Field Tags:"+tag.getName());
        }
    }




  ExpandableListViewAdapter listViewAdapter;
    ExpandableListView expandableListView;
    List<String> listaPreguntas;
    HashMap<String, List<String>> listaRespuestas;

    /* @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs);
        expandableListView = findViewById(R.id.eListView);

        showList();

        listViewAdapter = new ExpandableListViewAdapter(this, listaPreguntas, listaRespuestas);
        expandableListView.setAdapter(listViewAdapter);
    }
    */

    private void showList() {
        listaPreguntas = new ArrayList<String>();
        listaRespuestas = new HashMap<String, List<String>>();

        listaPreguntas.add("Pregunta 1");
        listaPreguntas.add("Pregunta 2");
        listaPreguntas.add("Pregunta 3");
        listaPreguntas.add("Pregunta 4");

        List<String> topic1 = new ArrayList<>();
        topic1.add("respuesta 1");


        List<String> topic2 = new ArrayList<>();
        topic2.add("respuesta 2");


        List<String> topic3 = new ArrayList<>();
        topic3.add("respuesta3");


        List<String> topic4 = new ArrayList<>();
        topic4.add("respuesta4");


        listaRespuestas.put(listaPreguntas.get(0), topic1);
        listaRespuestas.put(listaPreguntas.get(1), topic2);
        listaRespuestas.put(listaPreguntas.get(2), topic3);
        listaRespuestas.put(listaPreguntas.get(3), topic4);


    }
}