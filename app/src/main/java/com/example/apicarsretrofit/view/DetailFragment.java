package com.example.apicarsretrofit.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.apicarsretrofit.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailFragment extends Fragment {

    private closeDetails closeDetails;

    public FloatingActionButton closeButton;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View detailView = inflater.inflate(R.layout.car_detail, container, false);

        closeButton = detailView.findViewById(R.id.close_detail_button);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeDetails.hiddeDetails();
            }
        });

        return detailView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = view.findViewById(R.id.fragment_detail_imageview);
        TextView textView1 = view.findViewById(R.id.fragment_detail_textview1);
        TextView textView2 = view.findViewById(R.id.fragment_detail_textview2);
        TextView textView3 = view.findViewById(R.id.fragment_detail_textview3);
        TextView textView4 = view.findViewById(R.id.fragment_detail_textview4);

                imageView.setImageResource(R.drawable.lambo);
                if (getArguments() != null) {
                    textView1.setText(getArguments().getString("marca"));
                    textView2.setText(getArguments().getString("modelo"));
                    textView3.setText(getArguments().getString("matricula"));
                    if (getArguments().getBoolean("disponible")) {
                        textView4.setText(R.string.available_car);
                    } else {
                        textView4.setText(R.string.not_available_car);
                    }
                }
       /*         break;
            case VIEW_ORDER_ACTIVITY:
                if (getArguments() != null) {
                    if (getArguments().getByteArray("bike_image") != null)
                        imageView.setImageBitmap
                                (ImageUtils.getBitmap(getArguments().getByteArray("bike_image")));
                    textView1.setText(DateUtils.fromLocalDateToMyDateFormatString
                            (LocalDate.parse(getArguments().getString("date"))));
                    textView2.setText(getArguments().getString("name"));
                    textView3.setText(getArguments().getString("model") + " || " + getArguments().getString("license"));
                    textView4.setText(getArguments().getString("description"));
                }
                break;
        }   // End switch*/
    }

    /**
     * Interfaz para comunicar el boton de cerrar con la clase desde la que se llama al fragment
     * sobreescribiendolo en esta
     */
    public interface closeDetails {
        void hiddeDetails();
    }

    /**
     * Se llama cuando un fragmento se adjunta por primera vez a su contexto (La clase que lo llama).
     * {@link #onCreate(Bundle)} will be called after this.
     *
     * @param context
     */
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof closeDetails) {
            closeDetails = (DetailFragment.closeDetails) context;
        } else {
            throw new RuntimeException(context.toString());
        }
    }
}