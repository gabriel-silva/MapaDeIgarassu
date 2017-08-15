package iphan.pibex.igarassu.ifpe.edu.br;

import android.*;
import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.MessageButtonBehaviour;
import agency.tango.materialintroscreen.SlideFragmentBuilder;

/**
 * Created by gabri on 15/08/2017.
 */

public class IntroActivity extends MaterialIntroActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        verifyIntroActivity();
        addSlide(
                new SlideFragmentBuilder()
                        .backgroundColor(R.color.slide_1)
                        .buttonsColor(R.color.slide_button)
                        .title(getResources().getString(R.string.slide_1_title))
                        .description(getResources().getString(R.string.slide_1_description))
                        .image(R.mipmap.ic_launcher)
                        .build(),
                new MessageButtonBehaviour(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showMessage(getResources().getString(R.string.slide_1_button_message));
                    }
                }, getResources().getString(R.string.slide_1_button_label))
        );


        String[] neededPermissons = new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
        addSlide(
                new SlideFragmentBuilder()
                        .backgroundColor(R.color.slide_2)
                        .buttonsColor(R.color.slide_button)
                        .title(getResources().getString(R.string.slide_2_title))
                        .description(getResources().getString(R.string.slide_2_description))
                        .image(R.mipmap.ic_launcher)
                        .neededPermissions(neededPermissons)
                        .build()

        );

        addSlide(new TermsConditionsSlide());

    }

    private void verifyIntroActivity(){
        if(SharedPref.isIntroActivityShow(this)){
            Intent intent = new Intent(IntroActivity.this, MapActivity.class);
            startActivity(intent);
        }
    }

}