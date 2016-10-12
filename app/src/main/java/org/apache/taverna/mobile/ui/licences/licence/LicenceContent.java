package org.apache.taverna.mobile.ui.licences.licence;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create licence items from JSON string and add to list
 */
public class LicenceContent {

    /**
     * An array of licence items.
     */
    public static final List<LicenceItem> ITEMS = new ArrayList<LicenceItem>();
    private static String licence_json = "[{'library': 'dropbox-android-sdk','version': '1.6.3'}, {'library': 'json_simple','version': '1.1'}, {'libary': 'sjxp','version': '2.2'}, {'library': 'com.android.support:appcompat','version': 'v7:23.3.0'}, {'library': 'com.android.support:cardview','version': 'v7:23.3.0'}, {'library': 'com.android.support:recyclerview','version': 'v7:23.3.0'}, {'library': 'com.android.support:support','version': 'v4:23.3.0'}, {'library': 'com.android.support:design','version': ':23.3.0'}, {'library': 'com.squareup.retrofit2:retrofit','version': '2.0.2'}, {'library': 'com.squareup.retrofit2:adapter-rxjava',    'version': '2.0.2'}, {    'library': 'com.squareup.okhttp3:logging-interceptor',    'version': '3.2.0'}, {    'library': 'com.squareup.retrofit2:converter-simplexml',    'version': '2.0.2'}, {    'library': 'com.jakewharton:butterknife',    'version': '8.0.1'}, {    'library': 'com.jakewharton:butterknife-compiler',    'version': '8.0.1'}, {'library': 'io.reactivex:rxandroid', 'version': '1.2.0'}, {'library': 'io.reactivex:rxjava', 'version': '1.1.4'}, {'library': 'org.simpleframework:simple-xml',    'version': '2.7. +'}, {    'library': 'com.github.bumptech.glide:glide',    'version': '3.6.0'}, {    'libray': 'com.caverock:androidsvg',    'version': '1.2.1'}, {    'library': 'com.github.Raizlabs.DBFlow:dbflow-processor',    'version': '3.0.1'}, {    'library': 'com.github.Raizlabs.DBFlow:dbflow-core',    'version': '3.0.1'}, {    'library': 'com.github.Raizlabs.DBFlow:dbflow',    'version': '3.0.1'}, {    'library': 'com.facebook.stetho:stetho',    'version': '1.3.1'}, {    'library': 'com.facebook.stetho:stetho-okhttp',    'version': '3: 1.3.1'}, {    'library': 'com.github.chrisbanes:PhotoView',    'version': '1.2.6'}, {    'library': 'com.androidsupport:multidex','version': '1.0.0'}, {'library': 'com.google.code.gson:gson','version': '2.7'}, {'library': 'com.squareup.retrofit2:converter-gson','version': '2.0.2'}, {'library': 'com.anton46:stepsview','version': '0.0.2'}]";

    static {
        JSONArray licenceList = null;
        try {
            licenceList = new JSONArray(licence_json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (int i=0; i < licenceList.length(); i++) {
            try {
                JSONObject libraryDetails = licenceList.getJSONObject(i);
                String libraryName = libraryDetails.getString("library");
                String libraryVersion = libraryDetails.getString("version");
                addItem(createLicenceItem(i, libraryName, libraryVersion, ""));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static void addItem(LicenceItem item) {
        ITEMS.add(item);
    }

    private static LicenceItem createLicenceItem(int position, String name, String version, String licence) {
        return new LicenceItem(String.valueOf(position), name, version, licence);
    }

    /**
     * A licence item containing info about a library used by the app.
     */
    public static class LicenceItem {
        public final String id;
        public final String name;
        public final String version;
        public final String licence;

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getVersion() {
            return version;
        }

        public String getLicence() {
            return licence;
        }

        public LicenceItem(String id, String name, String version, String licence) {
            this.id = id;
            this.name = name;
            this.version = version;
            this.licence = licence;
        }

        @Override
        public String toString() {
            return name + " " + version + " " + licence;
        }
    }
}
