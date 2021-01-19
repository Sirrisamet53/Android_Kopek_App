package com.h5190047.sirri_samet_keles_final.adaptor;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.h5190047.sirri_samet_keles_final.R;
import org.w3c.dom.Text;
public class KopekViewHolder extends RecyclerView.ViewHolder {

    ImageView imgKopekLogo;
    TextView txtKopekAdi;
    TextView txtYasamSuresi;
    TextView txtKariyerineBasladigiYer;
    public KopekViewHolder(@NonNull View itemView,KopekAdaptor.OnItemClickListener itemClickListener) {
        super(itemView);

        imgKopekLogo =itemView.findViewById(R.id.imgKopekLogo);
        txtKopekAdi =itemView.findViewById(R.id.txtKopekAdi);
        txtYasamSuresi =itemView.findViewById(R.id.txtYasamSuresi);
        txtKariyerineBasladigiYer =itemView.findViewById(R.id.txtKariyerineBasladigiYer);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onClick(getAdapterPosition());
            }
        });

    }
}
