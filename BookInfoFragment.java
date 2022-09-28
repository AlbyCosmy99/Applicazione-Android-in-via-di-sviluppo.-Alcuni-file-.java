package andrei.albu.year2020.myhistoryasareader;

import android.net.Uri;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.widget.LockableNestedScrollView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class BookInfoFragment extends TagFragment {

    public static final String KEY = "BookInfoFragment";

    Book book;

    View view1;
    View view2;
    View view3;

    CardView cardView2;
    CardView cardView3;
    CardView cardView4;
    CardView cardView5;
    CardView cardView6;
    CardView cardView7;
    CardView cardView8;
    CardView cardView9;
    CardView cardView10;
    CardView cardView11;
    CardView cardView12;
    CardView cardView13;
    CardView cardView14;
    CardView cardView15;
    CardView cardView16;
    CardView cardView17;
    CardView cardView18;
    CardView cardView19;
    CardView cardView20;
    CardView cardView21;
    CardView cardView22;
    CardView cardView23;
    CardView cardView24;
    CardView cardView25;
    CardView cardView26;
    CardView cardView27;
    CardView cardView28;

    LockableNestedScrollView lockableNestedScrollView1;
    NestedScrollView nestedScrollView1;
    NestedScrollView nestedScrollView2;
    NestedScrollView nestedScrollView3;

    RelativeLayout relativeLayout6;

    ImageButton imageButton;

    //button9 used to modify a book
    ImageButton imageButton2;

    ImageButton imageButton3;

    ImageView imageView5;

    TextView textView1;
    TextView textView4;
    TextView textView5;
    TextView textView7;
    TextView textView8;
    TextView textView10;
    TextView textView12;
    TextView textView14;
    TextView textView16;
    TextView textView21;
    TextView textView23;
    TextView textView25;
    TextView textView27;
    TextView textView28;
    TextView textView30;
    TextView textView32;
    TextView textView34;
    TextView textView36;
    TextView textView37;
    TextView textView38;
    TextView textView40;
    TextView textView42;
    TextView textView44;

    public BookInfoFragment() {
        super(KEY);
    }

    public BookInfoFragment(Book book){
        super(KEY);
        this.book = book;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_book_info, container, false);

        imageButton2 = view.findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentHelper.addFragment((AppCompatActivity) getContext(), ((MainActivity)getContext()).getFragmentAnchorID(),new AddBookFragment(book));
            }
        });

        relativeLayout6 = view.findViewById(R.id.relativeLayout6);

        cardView2 = view.findViewById(R.id.cardView2);
        int cardView2Height = (MainActivityChannel.getHeightScreen((MainActivity)getContext())*3)/10;
        int cardView2Width = (cardView2Height*7)/10;
        RelativeLayout.LayoutParams cardView2params = new RelativeLayout.LayoutParams(cardView2Width,cardView2Height);
        cardView2params.addRule(RelativeLayout.CENTER_IN_PARENT);
        cardView2params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        cardView2.setLayoutParams(cardView2params);

        int cardViewHeight = cardView2Height*3/13;

        int view1Height = cardViewHeight*8/10;

        view1 = view.findViewById(R.id.view1);
        RelativeLayout.LayoutParams view1Params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,view1Height);
        view1Params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        view1.setLayoutParams(view1Params);

        view2 = view.findViewById(R.id.view2);
        RelativeLayout.LayoutParams view2Params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,view1Height/2);
        view2Params.addRule(RelativeLayout.BELOW,relativeLayout6.getId());
        view2.setLayoutParams(view2Params);

        cardView3 = view.findViewById(R.id.cardView3);
        RelativeLayout.LayoutParams cardView3params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, cardViewHeight);
        cardView3params.addRule(RelativeLayout.BELOW,view2.getId());
        cardView3.setLayoutParams(cardView3params);

        cardView4 = view.findViewById(R.id.cardView4);
        RelativeLayout.LayoutParams cardView4params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, cardViewHeight);
        cardView4params.addRule(RelativeLayout.BELOW,cardView3.getId());
        cardView4.setLayoutParams(cardView4params);

        cardView5 = view.findViewById(R.id.cardView5);
        RelativeLayout.LayoutParams cardView5params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,cardViewHeight);
        cardView5params.addRule(RelativeLayout.BELOW,cardView4.getId());
        cardView5.setLayoutParams(cardView5params);

        cardView6 = view.findViewById(R.id.cardView6);
        RelativeLayout.LayoutParams cardView6params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,cardViewHeight);
        cardView6params.addRule(RelativeLayout.BELOW,cardView5.getId());
        cardView6.setLayoutParams(cardView6params);

        cardView7 = view.findViewById(R.id.cardView7);
        RelativeLayout.LayoutParams cardView7params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,cardViewHeight);
        cardView7params.addRule(RelativeLayout.BELOW,cardView6.getId());
        cardView7.setLayoutParams(cardView7params);

        cardView8 = view.findViewById(R.id.cardView8);
        RelativeLayout.LayoutParams cardView8params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,cardViewHeight);
        cardView8params.addRule(RelativeLayout.BELOW,cardView7.getId());
        cardView8.setLayoutParams(cardView8params);

        cardView9 = view.findViewById(R.id.cardView9);
        RelativeLayout.LayoutParams cardView9params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,cardViewHeight);
        cardView9params.addRule(RelativeLayout.BELOW,cardView8.getId());
        cardView9.setLayoutParams(cardView9params);

        cardView10 = view.findViewById(R.id.cardView10);
        RelativeLayout.LayoutParams cardView10params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,cardViewHeight);
        cardView10params.addRule(RelativeLayout.BELOW,cardView9.getId());
        cardView10.setLayoutParams(cardView10params);

        cardView11 = view.findViewById(R.id.cardView11);
        RelativeLayout.LayoutParams cardView11params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,cardViewHeight);
        cardView11params.addRule(RelativeLayout.BELOW,cardView10.getId());
        cardView11.setLayoutParams(cardView11params);

        cardView12 = view.findViewById(R.id.cardView12);

        cardView13 = view.findViewById(R.id.cardView13);
        RelativeLayout.LayoutParams cardView13params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,cardViewHeight);
        cardView13params.addRule(RelativeLayout.BELOW,cardView12.getId());
        cardView13.setLayoutParams(cardView13params);

        cardView14 = view.findViewById(R.id.cardView14);
        RelativeLayout.LayoutParams cardView14params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,cardViewHeight);
        cardView14params.addRule(RelativeLayout.BELOW,cardView13.getId());
        cardView14.setLayoutParams(cardView14params);

        cardView15 = view.findViewById(R.id.cardView15);
        RelativeLayout.LayoutParams cardView15params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,cardViewHeight);
        cardView15params.addRule(RelativeLayout.BELOW,cardView14.getId());
        cardView15.setLayoutParams(cardView15params);

        cardView16 = view.findViewById(R.id.cardView16);
        RelativeLayout.LayoutParams cardView16params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,cardViewHeight);
        cardView16params.addRule(RelativeLayout.BELOW,cardView15.getId());
        cardView16.setLayoutParams(cardView16params);

        cardView17 = view.findViewById(R.id.cardView17);
        RelativeLayout.LayoutParams cardView17params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,cardViewHeight);
        cardView17params.addRule(RelativeLayout.BELOW,cardView16.getId());
        cardView17.setLayoutParams(cardView17params);

        cardView18 = view.findViewById(R.id.cardView18);
        RelativeLayout.LayoutParams cardView18params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,cardViewHeight);
        cardView18params.addRule(RelativeLayout.BELOW,cardView17.getId());
        cardView18.setLayoutParams(cardView18params);

        cardView19 = view.findViewById(R.id.cardView19);
        RelativeLayout.LayoutParams cardView19params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,cardViewHeight);
        cardView19params.addRule(RelativeLayout.BELOW,cardView18.getId());
        cardView19.setLayoutParams(cardView19params);

        cardView20 = view.findViewById(R.id.cardView20);
        RelativeLayout.LayoutParams cardView20params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,cardViewHeight);
        cardView20params.addRule(RelativeLayout.BELOW,cardView19.getId());
        cardView20.setLayoutParams(cardView20params);

        cardView21 = view.findViewById(R.id.cardView21);
        RelativeLayout.LayoutParams cardView21params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,cardViewHeight);
        cardView21params.addRule(RelativeLayout.BELOW,cardView20.getId());
        cardView21.setLayoutParams(cardView21params);

        cardView22 = view.findViewById(R.id.cardView22);
        RelativeLayout.LayoutParams cardView22params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,cardViewHeight);
        cardView22params.addRule(RelativeLayout.BELOW,cardView21.getId());
        cardView22.setLayoutParams(cardView22params);

        cardView23 = view.findViewById(R.id.cardView23);

        cardView24 = view.findViewById(R.id.cardView24);
        RelativeLayout.LayoutParams cardView24params = new RelativeLayout.LayoutParams(MainActivityChannel.getWidthScreen((MainActivity)getContext())-2*view1Height,cardViewHeight*getContext().getResources().getInteger(R.integer.description_notes_height_multiplier));
        cardView24params.addRule(RelativeLayout.BELOW,cardView23.getId());
        cardView24params.addRule(RelativeLayout.CENTER_IN_PARENT);
        cardView24.setLayoutParams(cardView24params);

        cardView25 = view.findViewById(R.id.cardView25);

        cardView26 = view.findViewById(R.id.cardView26);
        RelativeLayout.LayoutParams cardView26params = new RelativeLayout.LayoutParams(MainActivityChannel.getWidthScreen((MainActivity)getContext())-2*view1Height,cardViewHeight*getContext().getResources().getInteger(R.integer.description_notes_height_multiplier));
        cardView26params.addRule(RelativeLayout.BELOW,cardView25.getId());
        cardView26params.addRule(RelativeLayout.CENTER_IN_PARENT);
        cardView26.setLayoutParams(cardView26params);

        cardView27 = view.findViewById(R.id.cardView27);

        cardView28 = view.findViewById(R.id.cardView28);
        RelativeLayout.LayoutParams cardView28params = new RelativeLayout.LayoutParams(MainActivityChannel.getWidthScreen((MainActivity)getContext())-2*view1Height,cardViewHeight*getContext().getResources().getInteger(R.integer.description_notes_height_multiplier));
        cardView28params.addRule(RelativeLayout.BELOW,cardView27.getId());
        cardView28params.addRule(RelativeLayout.CENTER_IN_PARENT);
        cardView28.setLayoutParams(cardView28params);

        view3 = view.findViewById(R.id.view3);
        RelativeLayout.LayoutParams view3Params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,view1Height);
        view3Params.addRule(RelativeLayout.BELOW,cardView26.getId());
        view3.setLayoutParams(view3Params);

        //improving the readability of the description and the notes
        nestedScrollView1 = view.findViewById(R.id.nestedScrollView1);
        nestedScrollView2 = view.findViewById(R.id.nestedScrollView2);
        lockableNestedScrollView1 = view.findViewById(R.id.lockableNestedScrollView1);

        nestedScrollView1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(cardView24.getHeight() < textView40.getHeight()){
                    lockableNestedScrollView1.setEnableScrolling(false);
                }
                else{
                    lockableNestedScrollView1.setEnableScrolling(true);
                }
                return false;
            }
        });

        nestedScrollView2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(cardView26.getHeight() < textView42.getHeight()){
                    lockableNestedScrollView1.setEnableScrolling(false);
                }
                else{
                    lockableNestedScrollView1.setEnableScrolling(true);
                }
                return false;
            }
        });

        lockableNestedScrollView1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(!lockableNestedScrollView1.isEnableScrolling()){
                    lockableNestedScrollView1.setEnableScrolling(true);
                }
                return false;
            }
        });


        imageView5 = view.findViewById(R.id.imageView5);

        if(book.getImageUriString().equals(Book.DEFAULT_STRING)){
            imageView5.setImageResource(book.getImageID());
        }
        else{
            imageView5.setImageURI(Uri.parse(book.getImageUriString()));
        }

        textView1 = view.findViewById(R.id.textView1);
        textView1.setText(book.getTitle());

        textView4 = view.findViewById(R.id.textView4);
        textView4.setText(book.getAuthor());

        textView5 = view.findViewById(R.id.textView5);
        textView5.setText(book.getGenre());

        textView7 = view.findViewById(R.id.textView7);
        textView7.setText(book.getLanguage());

        textView8 = view.findViewById(R.id.textView8);
        textView8.setText(book.getPublishing_house());

        textView10 = view.findViewById(R.id.textView10);
        textView10.setText(book.getNumberOfPages());

        textView12 = view.findViewById(R.id.textView12);
        textView12.setText(book.getPrice());

        textView14 = view.findViewById(R.id.textView14);
        textView14.setText(book.getIsbn());

        textView16 = view.findViewById(R.id.textView16);
        String publicationDateString = book.getPublicationDate().toString();

        if(publicationDateString.equals("0/0/0")){
            textView16.setText(Book.DEFAULT_STRING);
        }
        else{
            textView16.setText(book.getPublicationDate().toString());
        }

        textView21 = view.findViewById(R.id.textView21);
        if(book.isRead()){
            textView21.setText(R.string.yes);
        }
        else{
            textView21.setText(R.string.no);
        }

        textView23 = view.findViewById(R.id.textView23);
        if(book.isToRead()){
            textView23.setText(R.string.yes);
        }
        else{
            textView23.setText(R.string.no);
        }

        textView25 = view.findViewById(R.id.textView25);
        if(book.isReading()){
            textView25.setText(R.string.yes);
        }
        else{
            textView25.setText(R.string.no);
        }

        textView27 = view.findViewById(R.id.textView27);
        if(book.getPersonalRating().toString().equals("0/10")){
            textView27.setText(Book.DEFAULT_STRING);
        }
        else{
            textView27.setText(book.getPersonalRating().toString());
        }

        textView28 = view.findViewById(R.id.textView28);
        if(book.isFavorite()){
            textView28.setText(R.string.yes);
        }
        else{
            textView28.setText(R.string.no);
        }

        textView30 = view.findViewById(R.id.textView30);
        if(book.isLoaned()){
            textView30.setText(R.string.yes);
        }
        else{
            textView30.setText(R.string.no);
        }

        textView32 = view.findViewById(R.id.textView32);
        if(book.isBorrowed()){
            textView32.setText(R.string.yes);
        }
        else{
            textView32.setText(R.string.no);
        }

        textView34 = view.findViewById(R.id.textView34);
        String startReadingDateString = book.getStartReadingDate().toString();
        if(startReadingDateString.equals("0/0/0")){
            textView34.setText(Book.DEFAULT_STRING);
        }
        else{
            textView34.setText(book.getStartReadingDate().toString());
        }

        textView36 = view.findViewById(R.id.textView36);
        String finishReadingDateString = book.getFinishReadingDate().toString();
        if(finishReadingDateString.equals("0/0/0")){
            textView36.setText(Book.DEFAULT_STRING);
        }
        else{
            textView36.setText(book.getFinishReadingDate().toString());
        }

        textView38 = view.findViewById(R.id.textView38);
        String nowDateString = book.getWhenWasAddedOnTheApp().toString();
        if(nowDateString.equals("0/0/0")){
            textView38.setText(book.DEFAULT_STRING);
        }
        else{
            textView38.setText(book.getWhenWasAddedOnTheApp().toString());
        }

        textView40 = view.findViewById(R.id.textView40);
        if(book.getDescription().equals("")){
            textView40.setText(R.string.no_description);
        }
        else{
            textView40.setText(book.getDescription());
        }

        textView42 = view.findViewById(R.id.textView42);
        if(book.getNotes().equals("")){
            textView42.setText(R.string.no_notes);
        }
        else{
            textView42.setText(book.getNotes());
        }
        textView44 = view.findViewById(R.id.textView44);
        if(book.getFoldersWhichContainTheBook().size()==0){
            textView44.setText(R.string.no_folders);
        }
        else{
            String text = "";
            ArrayList<Folder> folders = book.getFoldersWhichContainTheBook();
            for(Folder folder : folders){
                text = text + folder.getName() + " ; ";
            }
            textView44.setText(text);
        }

        //improving the readability of the description and the notes
        nestedScrollView1 = view.findViewById(R.id.nestedScrollView1);
        nestedScrollView2 = view.findViewById(R.id.nestedScrollView2);
        nestedScrollView3 = view.findViewById(R.id.nestedScrollView2);
        lockableNestedScrollView1 = view.findViewById(R.id.lockableNestedScrollView1);

        nestedScrollView1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(cardView24.getHeight() < textView40.getHeight()){
                    lockableNestedScrollView1.setEnableScrolling(false);
                }
                else{
                    lockableNestedScrollView1.setEnableScrolling(true);
                }
                return false;
            }
        });

        nestedScrollView2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(cardView26.getHeight() < textView42.getHeight()){
                    lockableNestedScrollView1.setEnableScrolling(false);
                }
                else{
                    lockableNestedScrollView1.setEnableScrolling(true);
                }
                return false;
            }
        });

        nestedScrollView3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(cardView28.getHeight() < textView44.getHeight()){
                    lockableNestedScrollView1.setEnableScrolling(false);
                }
                else{
                    lockableNestedScrollView1.setEnableScrolling(true);
                }
                return false;
            }
        });

        lockableNestedScrollView1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(!lockableNestedScrollView1.isEnableScrolling()){
                    lockableNestedScrollView1.setEnableScrolling(true);
                }
                return false;
            }
        });

        imageButton = view.findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentHelper.addFragment((AppCompatActivity) Objects.requireNonNull(getContext()),((MainActivity)getContext()).getFragmentAnchorID(),new MainFragment());
            }
        });

        imageButton3 = view.findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lastListFragment = new SharedPreferencesChannel(getContext(),SharedPreferencesChannel.SHARED_PREFERENCES_NAME_LAST_LISTFRAGMENT_OPENED,false).readPairStringString(SharedPreferencesChannel.LAST_LISTFRAGMENT_KEY);
                FragmentHelper.addFragment((AppCompatActivity)getContext(),((MainActivity) getContext()).getFragmentAnchorID(),new BooksListFragment(lastListFragment));
            }
        });

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                String lastListFragment = new SharedPreferencesChannel(getContext(),SharedPreferencesChannel.SHARED_PREFERENCES_NAME_LAST_LISTFRAGMENT_OPENED,false).readPairStringString(SharedPreferencesChannel.LAST_LISTFRAGMENT_KEY);
                FragmentHelper.addFragment((AppCompatActivity)getContext(),((MainActivity) getContext()).getFragmentAnchorID(),new BooksListFragment(lastListFragment));
            }
        };

        requireActivity().getOnBackPressedDispatcher().addCallback(this,callback);

        return view;
    }
}
