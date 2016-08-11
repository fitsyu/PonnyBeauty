package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import net.fitsyu.ponnybeauty.R;

/**
 * Created by fitsyu on 8/7/16.
 */
public class ItemAdapter extends BaseAdapter {


    private Context mContext;

    public ItemAdapter(Context c){
        mContext = c;
    }

    private Integer[] itemIDs =
            {
                    R.drawable.goku0,
                    R.drawable.goku1,
                    R.drawable.goku2,
                    R.drawable.goku2
            };

    private String[] itemsText =
            {
                    "Son Goku",
                    "Bezita",
                    "Son Gohan",
                    "Raditz"
            };

    @Override
    public int getCount() {
        return itemIDs.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        ImageView itemView;
//        if ( convertView == null ){
//            itemView = new ImageView(mContext);
//            itemView.setLayoutParams(new GridView.LayoutParams(85, 85));
//            itemView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            itemView.setPadding(10, 10, 10, 10);
//
//
//        } else {
//            itemView = (ImageView) convertView;
//        }
//
//        itemView.setImageResource(itemIDs[position]);
//        return itemView;

        View itemView;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if ( convertView == null ){
//            itemView = new View(mContext);
            itemView = inflater.inflate(R.layout.grid_item, null);

            ((ImageView) itemView.findViewById(R.id.itemPic) ).setImageResource(itemIDs[position]);
            ((TextView) itemView.findViewById(R.id.itemText) ).setText(itemsText[position]);

        }
        else {
            itemView = convertView;
        }

        return  itemView;

    }


}
