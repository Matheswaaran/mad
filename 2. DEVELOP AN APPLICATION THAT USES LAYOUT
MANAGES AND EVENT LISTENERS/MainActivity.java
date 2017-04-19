package app1.myapplication;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends Activity implements View.OnClickListener
{
Button button; EditText editText; EditText editText2; TextView textView4;
@Override
protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
button = (Button) findViewById(R.id.button); editText = (EditText)
findViewById(R.id.editText); editText2 = (EditText) findViewById(R.id.editText2); textView4 =
(TextView) findViewById(R.id.textView3); button.setOnClickListener(this);
}
public void onClick(View view) { int a,b,c; a=Integer.parseInt(editText.getText().toString());
b=Integer.parseInt(editText2.getText().toString()); c=a+b; textView4.setText("The result is "+c);
}
}
