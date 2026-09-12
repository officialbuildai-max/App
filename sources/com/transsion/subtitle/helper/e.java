package com.transsion.subtitle.helper;

import android.os.Build;
import android.os.LocaleList;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.download.SubtitleBean;
import com.transsion.baselib.db.download.SubtitleLanguageMapBean;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* loaded from: classes6.dex */
public abstract class e {
    public static final Locale a() {
        Locale locale;
        LocaleList locales;
        String string = com.transsion.baselib.report.launch.b.f43424a.b().getString("k_language_short_name", null);
        if (Build.VERSION.SDK_INT >= 24) {
            locales = Utils.a().getResources().getConfiguration().getLocales();
            locale = locales.get(0);
        } else {
            locale = Utils.a().getResources().getConfiguration().locale;
        }
        if (!Intrinsics.c(locale.getLanguage(), string) && string != null && string.length() > 0) {
            return new Locale(string, locale.getCountry());
        }
        Intrinsics.e(locale);
        return locale;
    }

    public static final String b(eu.a aVar) {
        SubtitleDownloadTable b11;
        String fileCharsetName;
        if (aVar != null && (b11 = aVar.b()) != null && (fileCharsetName = b11.getFileCharsetName()) != null) {
            return fileCharsetName;
        }
        String name = Charsets.UTF_8.name();
        Intrinsics.g(name, "name(...)");
        return name;
    }

    public static final boolean c(String language, List list) {
        String str;
        Intrinsics.h(language, "language");
        Intrinsics.h(list, "list");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String lan = ((SubtitleBean) it.next()).getLan();
            if (lan != null) {
                str = lan.toUpperCase(Locale.ROOT);
                Intrinsics.g(str, "toUpperCase(...)");
            } else {
                str = null;
            }
            String upperCase = language.toUpperCase(Locale.ROOT);
            Intrinsics.g(upperCase, "toUpperCase(...)");
            if (Intrinsics.c(str, upperCase)) {
                return true;
            }
        }
        return false;
    }

    public static final void d(List list) {
        Locale locale;
        LocaleList locales;
        Intrinsics.h(list, "list");
        if (Build.VERSION.SDK_INT >= 24) {
            locales = Utils.a().getResources().getConfiguration().getLocales();
            locale = locales.get(0);
        } else {
            locale = Utils.a().getResources().getConfiguration().locale;
        }
        int size = list.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                i11 = -1;
                break;
            }
            SubtitleLanguageMapBean subtitleLanguageMapBean = (SubtitleLanguageMapBean) list.get(i11);
            if (Intrinsics.c(Intrinsics.c(subtitleLanguageMapBean.getLan(), "in_id") ? "in" : subtitleLanguageMapBean.getLan(), locale.getLanguage())) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 > 0) {
            list.add(0, (SubtitleLanguageMapBean) list.remove(i11));
        }
    }
}
