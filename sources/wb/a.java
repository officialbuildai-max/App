package wb;

import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONObject;
import vb.g;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final File f77761a;

    public a(g gVar) {
        this.f77761a = gVar.g("com.crashlytics.settings.json");
    }

    private File a() {
        return this.f77761a;
    }

    public JSONObject b() {
        Throwable th2;
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        ob.g.f().b("Checking for cached settings...");
        FileInputStream fileInputStream2 = null;
        try {
            try {
                File a11 = a();
                if (a11.exists()) {
                    fileInputStream = new FileInputStream(a11);
                    try {
                        jSONObject = new JSONObject(CommonUtils.A(fileInputStream));
                        fileInputStream2 = fileInputStream;
                    } catch (Exception e11) {
                        e = e11;
                        ob.g.f().e("Failed to fetch cached settings", e);
                        CommonUtils.f(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    }
                } else {
                    ob.g.f().i("Settings file does not exist.");
                    jSONObject = null;
                }
                CommonUtils.f(fileInputStream2, "Error while closing settings cache file.");
                return jSONObject;
            } catch (Throwable th3) {
                th2 = th3;
                CommonUtils.f(null, "Error while closing settings cache file.");
                throw th2;
            }
        } catch (Exception e12) {
            e = e12;
            fileInputStream = null;
        } catch (Throwable th4) {
            th2 = th4;
            CommonUtils.f(null, "Error while closing settings cache file.");
            throw th2;
        }
    }

    public void c(long j11, JSONObject jSONObject) {
        FileWriter fileWriter;
        ob.g.f().i("Writing settings to cache file...");
        if (jSONObject != null) {
            FileWriter fileWriter2 = null;
            try {
                try {
                    jSONObject.put("expires_at", j11);
                    fileWriter = new FileWriter(a());
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e11) {
                e = e11;
            }
            try {
                fileWriter.write(jSONObject.toString());
                fileWriter.flush();
                CommonUtils.f(fileWriter, "Failed to close settings writer.");
            } catch (Exception e12) {
                e = e12;
                fileWriter2 = fileWriter;
                ob.g.f().e("Failed to cache settings", e);
                CommonUtils.f(fileWriter2, "Failed to close settings writer.");
            } catch (Throwable th3) {
                th = th3;
                fileWriter2 = fileWriter;
                CommonUtils.f(fileWriter2, "Failed to close settings writer.");
                throw th;
            }
        }
    }
}
