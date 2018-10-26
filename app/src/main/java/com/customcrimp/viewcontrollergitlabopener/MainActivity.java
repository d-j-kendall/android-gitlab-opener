package com.customcrimp.viewcontrollergitlabopener;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.content.Intent;
import android.net.Uri;
import android.content.res.Resources;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends Activity {
    private String openTicketUrl = "";
    private String newTicketUrl  = "";
    //private String emailTicketString = "incoming+customcrimp/connected_controller/engineering_requests+5n6u8yfgnxmmjy8ca84vs02ok@incoming.gitlab.com";
    private String mergeRequestUrl = "";
    private String searchTicketUrl  = "";
    private String wikiUrl = "https://gitlab.com/customcrimp/connected_controller/wiki-2017-general_documentation/blob/master/README.md";
    private boolean checked = false;
    private boolean textBoxFirstClick = false;
    @BindView(R.id.editText)
    EditText editTextString;
    @BindView(R.id.radioGroup1)
    RadioGroup leftRadioGroup;
    @BindView(R.id.radioGroup2)
    RadioGroup rightRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void onRadioSelect(View view){
        this.checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.engineering:
                rightRadioGroup.clearCheck();
                this.openTicketUrl = "https://gitlab.com/customcrimp/connected_controller/engineering_requests/issues/";
                this.newTicketUrl = "https://gitlab.com/customcrimp/connected_controller/engineering_requests/issues/new?issue%5Bassignee_id%5D=&issue%5Bmilestone_id%5D=";
                this.searchTicketUrl = "https://gitlab.com/customcrimp/connected_controller/engineering_requests/issues?scope=all&utf8=✓&state=opened&search=";
                this.mergeRequestUrl = "https://gitlab.com/customcrimp/connected_controller/plc-2017-connected_controller_programs/merge_requests/";
                break;
            case R.id.crimpIq:
                rightRadioGroup.clearCheck();
                this.openTicketUrl = "https://gitlab.com/customcrimp/connected_controller/andr-2016-crimp_controller/issues/";
                this.newTicketUrl = "https://gitlab.com/customcrimp/connected_controller/andr-2016-crimp_controller/issues/new?issue%5Bassignee_id%5D=&issue%5Bmilestone_id%5D=";
                this.searchTicketUrl = "https://gitlab.com/customcrimp/connected_controller/andr-2016-crimp_controller/issues?scope=all&utf8=✓&state=opened&search=";
                this.mergeRequestUrl = "https://gitlab.com/customcrimp/connected_controller/andr-2016-crimp_controller/merge_requests/";
                break;
            case R.id.myCrimp:
                leftRadioGroup.clearCheck();
                this.openTicketUrl = "https://gitlab.com/customcrimp/connected_controller/issues-2018-mycrimp_issue_tracker/issues/";
                this.newTicketUrl = "https://gitlab.com/customcrimp/connected_controller/issues-2018-mycrimp_issue_tracker/issues/new?issue%5Bassignee_id%5D=&issue%5Bmilestone_id%5D=";
                this.searchTicketUrl = "https://gitlab.com/customcrimp/connected_controller/issues-2018-mycrimp_issue_tracker/issues?scope=all&utf8=✓&state=opened&search=";
                this.mergeRequestUrl = "https://gitlab.com/customcrimp/mycrimp/andr-2016-mycrimp-all/merge_requests/";
                break;
            case R.id.crimpCloud:
                leftRadioGroup.clearCheck();
                this.openTicketUrl = "https://gitlab.com/customcrimp/connected_controller/ruby-2016-crimp_cloud/issues/";
                this.newTicketUrl = "https://gitlab.com/customcrimp/connected_controller/ruby-2016-crimp_cloud/issues/new?issue%5Bassignee_id%5D=&issue%5Bmilestone_id%5D=";
                this.searchTicketUrl = "https://gitlab.com/customcrimp/connected_controller/ruby-2016-crimp_cloud/issues?scope=all&utf8=✓&state=opened&search=";
                this.mergeRequestUrl = "https://gitlab.com/customcrimp/connected_controller/ruby-2016-crimp_cloud/merge_requests/";
                break;
            default:
                break;

        }






        }

    public void onOpenTicket(View view){
        Log.d("log",editTextString.getText().toString());
        if(checked)
            GoToURL(openTicketUrl);

    }
    public void onNewTicket(View view){
        if(checked)
            GoToURL(newTicketUrl);
    }

    public void onSearch(View view){
        if(checked)
            GoToURL(searchTicketUrl);

    }
    public void onMergeRequest(View view){
        if(checked)
            GoToURL(mergeRequestUrl);
    }
    public void onWikiClick(View view){
        GoToURL(wikiUrl,false);
    }

    private void GoToURL(String url,boolean concatenate){
        Uri uri = null;
        String ticketNumber = (editTextString.getText().toString()).trim();
        if(concatenate == true) {
            uri = Uri.parse(url + ticketNumber);
        }

        else
        {
            uri = Uri.parse(url);
        }
        Intent intent= new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
    public void GoToURL(String url){
        GoToURL(url,true);
    }
    public void clearTextBox(View view){
        if(!textBoxFirstClick){
            editTextString.setText("");
            textBoxFirstClick = true;
        }


    }

}
