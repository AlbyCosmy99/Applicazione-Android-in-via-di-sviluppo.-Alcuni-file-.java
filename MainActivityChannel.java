package andrei.albu.year2020.myhistoryasareader;

import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowMetrics;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivityChannel {

    public static void switchOffMainActivityOptions(MainActivity mainActivity){
        if(mainActivity.getOne_of_buttons_0_1_2_3_4_pressed()){
            //linearLayout1
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,mainActivity.getStarter_height_linear_layout1());
            mainActivity.getLinearLayout1().setLayoutParams(layoutParams);

            //linearLayout2
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,mainActivity.getStarter_height_linear_layout2());
            mainActivity.getLinearLayout2().setLayoutParams(layoutParams2);

            //imageButton
            setImageButtonToInitialPosition(mainActivity,mainActivity.getImageButton());
            //imageButton1
            setImageButtonToInitialPosition(mainActivity,mainActivity.getImageButton1());
            //imageButton2
            setImageButtonToInitialPosition(mainActivity,mainActivity.getImageButton2());
            //imageButton3
            setImageButtonToInitialPosition(mainActivity,mainActivity.getImageButton3());
            //imageButton4
            setImageButtonToInitialPosition(mainActivity,mainActivity.getImageButton4());

            mainActivity.setOne_of_buttons_0_1_2_3_4_pressed(false);
            mainActivity.setAllImage_button_already_pressed(false);
        }
    }

	//metodo ausiliario per il metodo 'public static void switchOffMainActivityOptions(MainActivity mainActivity)'
    private static void setImageButtonToInitialPosition(MainActivity mainActivity, ImageButton imageButton){
        //imageButton
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(imageButton.getWidth(),mainActivity.getStarter_height_linear_layout1());
        imageButton.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams params_image_b1 = (LinearLayout.LayoutParams) imageButton.getLayoutParams();
        params_image_b1.gravity = Gravity.BOTTOM;
        imageButton.setLayoutParams(params_image_b1);
        imageButton.setBackgroundColor(Color.parseColor("#ff7ad9"));
    }

    public static int getHeightScreen(MainActivity mainActivity){
        return getDisplayMetrics(mainActivity).heightPixels;
    }

    public static int getWidthScreen(MainActivity mainActivity){
        return getDisplayMetrics(mainActivity).widthPixels;
    }
    private static DisplayMetrics getDisplayMetrics(MainActivity mainActivity){
        DisplayMetrics displayMetrics = new DisplayMetrics();

        //Code below is deprecated.
        mainActivity.getDisplay().getMetrics(displayMetrics);

        return displayMetrics;
    }
}
