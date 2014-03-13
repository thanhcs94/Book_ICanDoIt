package appbook.menu.com;

import com.example.bookapp.About;
import com.example.bookapp.R;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;
import appbook.anh.com.Chapter;
import appbook.viet.com.ChapterViet;


public class Menu extends Activity implements OnClickListener {

	Button btenglish, btvietnamese, btintrodutions, btabout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		setinit();
	}


	private void setinit() {
		btenglish =(Button)findViewById(R.id.btenglish);
		btvietnamese =(Button)findViewById(R.id.btvietnamese);
		btabout =(Button)findViewById(R.id.btabout);
		btenglish.setOnClickListener(this);
		btabout.setOnClickListener(this);
		btvietnamese.setOnClickListener(this);
	}


	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
	}


	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.btenglish:
		{

			Intent intent = new Intent(Menu.this, Chapter.class);
			startActivity(intent);
		}
		break;
		case R.id.btvietnamese:
		{

			Intent intent = new Intent(Menu.this, ChapterViet.class);
			startActivity(intent);
		}
		break;
		
		case R.id.btabout:
		{

			Intent intent = new Intent(Menu.this,About.class);
			startActivity(intent);
		}
		break;

		default:
			break;
		}

	}
}
