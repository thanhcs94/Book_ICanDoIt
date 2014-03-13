package appbook.customelistview.com;
import com.example.bookapp.R;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class MyarrayAdapter extends ArrayAdapter<String>{
	public String title[];
	public String description[];
	Integer []image;
	public Activity context;
	public LayoutInflater inflater;

	public MyarrayAdapter(Activity context,Integer []imageid,String[] title, String[] description) {
		super(context, R.layout.listtitle, title);
		this.context = context;
		this.title = title;
		this.image =imageid;
		this.description = description;

	    this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	
	public static class ViewHolder
	{
		ImageView imgViewLogo;
		TextView txtViewTitle;
		TextView txtViewDescription;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		ViewHolder holder;
		if(convertView==null)
		{
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.listtitle, null);

			holder.imgViewLogo = (ImageView) convertView.findViewById(R.id.icon);
			holder.txtViewTitle = (TextView) convertView.findViewById(R.id.firstline);
			holder.txtViewDescription = (TextView) convertView.findViewById(R.id.secondLine);

			convertView.setTag(holder);
		}
		else
			holder=(ViewHolder)convertView.getTag();

	//	holder.imgViewLogo.setImageResource(R.drawable.ic_title);
		holder.imgViewLogo.setImageResource(image[position]);
		holder.txtViewTitle.setText(title[position]);
		holder.txtViewDescription.setText(description[position]);

		return convertView;
	}

}
