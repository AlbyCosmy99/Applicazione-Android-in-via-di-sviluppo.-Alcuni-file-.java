package andrei.albu.year2020.myhistoryasareader;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChooseFolderBackgroundAdapter extends RecyclerView.Adapter<ChooseFolderBackgroundAdapter.ViewHolder> {

    private ArrayList<Folder> folders;
    private int screenHeight;
    private Context context;
    private SharedPreferencesChannel sharedPreferencesChannel;

    public ChooseFolderBackgroundAdapter(ArrayList<Folder> folders, Context context) {
        this.folders = folders;
        this.context = context;
        screenHeight = MainActivityChannel.getHeightScreen((MainActivity)context);
        sharedPreferencesChannel = new SharedPreferencesChannel(context,SharedPreferencesChannel.FOLDERS_WITH_BOOKS,false,true);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView53;
        CardView cardView1;
        CheckBox checkBox;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView53 = view.findViewById(R.id.textView53);
            checkBox = view.findViewById(R.id.checkBox);
            cardView1 = view.findViewById(R.id.cardView1);
        }

        public TextView getTextView53() {
            return textView53;
        }

        public CardView getCardView1() {
            return cardView1;
        }

        public CheckBox getCheckBox() {
            return checkBox;
        }
    }

    // Create new views 
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.choose_folder_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view 
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        SharedPreferencesChannel checkedSP = new SharedPreferencesChannel(context,SharedPreferencesChannel.CHECKED_FOLDERS,false);
        ArrayList<Folder> foldersSh = sharedPreferencesChannel.getFolders();
        viewHolder.textView53.setText(foldersSh.get(position).getName());
        for(Folder folder : folders){
            if(folder.equals(foldersSh.get(position))){
                viewHolder.checkBox.setChecked(true);
                checkedSP.addPairStringString(foldersSh.get(position).getKey(),"true");
                break;
            }
            else{
                viewHolder.checkBox.setChecked(false);
                checkedSP.addPairStringString(foldersSh.get(position).getKey(),"false");
            }
        }
        if(checkedSP.contains(foldersSh.get(position).getKey())){
            if(checkedSP.readPairStringString(foldersSh.get(position).getKey()).equals("true")){
                viewHolder.checkBox.setChecked(true);
            }
            else{
                viewHolder.checkBox.setChecked(false);
            }


        }
        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(viewHolder.checkBox.isChecked()){
                    checkedSP.addPairStringString(foldersSh.get(position).getKey(),"true");
                }else{
                    checkedSP.addPairStringString(foldersSh.get(position).getKey(),"false");
                }
            }
        });
    }

    // Return the size of the dataset 
    @Override
    public int getItemCount() {
        return sharedPreferencesChannel.getFolders().size();
    }
}

