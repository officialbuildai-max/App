package com.mbridge.msdk.foundation.same.report.crashreport;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class b {
    public static List<String> a() {
        ArrayList arrayList = new ArrayList();
        try {
            g d11 = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            if (d11 == null) {
                d11 = h.b().a();
            }
            Matcher matcher = Pattern.compile("<mvpackage>([^<]+)</mvpackage>").matcher(d11.P());
            if (matcher.find()) {
                String group = matcher.group(1);
                if (!TextUtils.isEmpty(group)) {
                    String[] split = group.split(",");
                    if (split.length > 0) {
                        arrayList.addAll(Arrays.asList(split));
                    }
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.add("mbridge");
            }
            return arrayList;
        } catch (Exception e11) {
            o0.b("FilterStringUtil", e11.getMessage());
            arrayList.clear();
            arrayList.add("mbridge");
            return arrayList;
        }
    }

    public static JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
            if (d11 == null) {
                return jSONObject;
            }
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            long usableSpace = externalStorageDirectory.getUsableSpace();
            long totalSpace = externalStorageDirectory.getTotalSpace();
            String formatFileSize = Formatter.formatFileSize(d11, usableSpace);
            String formatFileSize2 = Formatter.formatFileSize(d11, totalSpace);
            jSONObject.put("max_memory", String.valueOf((float) ((Runtime.getRuntime().maxMemory() * 1.0d) / 1048576.0d)));
            jSONObject.put("memoryby_app", String.valueOf((float) ((Runtime.getRuntime().totalMemory() * 1.0d) / 1048576.0d)));
            jSONObject.put("remaining_memory", (float) ((Runtime.getRuntime().freeMemory() * 1.0d) / 1048576.0d));
            jSONObject.put("sdcard_remainder", formatFileSize);
            jSONObject.put("totalspacestr", formatFileSize2);
            jSONObject.put("crashtime", str);
            return jSONObject;
        } catch (Throwable th2) {
            o0.b("AbnormalExitUtil", th2.getMessage());
            return jSONObject;
        }
    }
}
