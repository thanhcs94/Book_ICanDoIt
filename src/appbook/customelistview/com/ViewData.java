package appbook.customelistview.com;



import com.example.bookapp.R;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewData extends Activity {

	TextView tvnoidung, tvtitle;
	String s ;
	String []noidunganh;
	String []noidungviet;
	
	String []titleanh;
	String []titleviet;
	Button btchange;
	static int postion, language, size, i=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_data);
		Resources r =getResources();
	
		noidunganh =r.getStringArray(R.array.noidunganh);
		noidungviet =r.getStringArray(R.array.noidungviet);	
		titleviet =r.getStringArray(R.array.titleviet);
		titleanh =r.getStringArray(R.array.titleanh);
			
		
			tvnoidung =(TextView)findViewById(R.id.viewdata);
			tvtitle =(TextView)findViewById(R.id.tvtitle);

			Intent inte = getIntent();
			s = inte.getStringExtra("Data");
			postion =inte.getIntExtra("postion", 0);
			language = inte.getIntExtra("language", 0);
			if(language==2)
			{
				tvtitle.setText(titleviet[postion]);
				i=2;
			}
			else 
			{
				tvtitle.setText(titleanh[postion]);
				i=1;
			}
			tvnoidung.setText(s);
			
			tvnoidung.setOnLongClickListener(new View.OnLongClickListener() {
				
				@Override
				public boolean onLongClick(View v) {
					Toast.makeText(ViewData.this, "Long Click", Toast.LENGTH_SHORT).show();
					i++;
					if(i%2!=0)
					{
						tvnoidung.setText(noidunganh[postion]);
						tvtitle.setText(titleanh[postion]);
					}
					else
					{
						tvnoidung.setText(noidungviet[postion]);
						tvtitle.setText(titleviet[postion]);
					}
					return false;
				}
			});
		
	}
	

}
