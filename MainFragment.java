/**
 Main Fragment. Interface displayed when the application is opened. Linked to the activity_main.xml file.
 */

package andrei.albu.year2020.myhistoryasareader;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

/**
 * MainFragment class. The first fragment displayed to the user.
 */
public class MainFragment extends TagFragment {

    public static final String KEY = "MainFragment";

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;

    public MainFragment() {
        super(KEY);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        button1 = view.findViewById(R.id.button1);
        button2 = view.findViewById(R.id.button2);
        button3 = view.findViewById(R.id.button3);
        button4 = view.findViewById(R.id.button4);
        button5 = view.findViewById(R.id.button5);

        /**
         * Method called when button1 is pressed.
         */
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentHelper.addFragment((AppCompatActivity) getContext(), ((MainActivity)getContext()).getFragmentAnchorID(),new BooksListFragment(SharedPreferencesChannel.SHARED_PREFERENCES_NAME_ALLMYBOOKS));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentHelper.addFragment((AppCompatActivity) getContext(), ((MainActivity)getContext()).getFragmentAnchorID(),new BooksListFragment(SharedPreferencesChannel.SHARED_PREFERENCES_NAME_READ));
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentHelper.addFragment((AppCompatActivity) getContext(), ((MainActivity)getContext()).getFragmentAnchorID(),new BooksListFragment(SharedPreferencesChannel.SHARED_PREFERENCES_NAME_NOT_READ));
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentHelper.addFragment((AppCompatActivity) getContext(), ((MainActivity)getContext()).getFragmentAnchorID(),new BooksListFragment(SharedPreferencesChannel.SHARED_PREFERENCES_NAME_TO_READ));
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentHelper.addFragment((AppCompatActivity) getContext(), ((MainActivity)getContext()).getFragmentAnchorID(),new BooksListFragment(SharedPreferencesChannel.SHARED_PREFERENCES_NAME_READING));
            }
        });

        return view;
    }
}
