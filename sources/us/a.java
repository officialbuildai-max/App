package us;

import android.os.Build;
import android.os.LocaleList;
import com.blankj.utilcode.util.Utils;
import com.transsion.shorttv.utils.h;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import ts.b;

/* loaded from: classes7.dex */
public abstract class a {
    public static final Locale a() {
        Locale locale;
        LocaleList locales;
        String string = h.f53707a.e().getString("k_language_short_name", null);
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

    public static final String b(b bVar) {
        SubtitleDownloadTable a11;
        String fileCharsetName;
        if (bVar != null && (a11 = bVar.a()) != null && (fileCharsetName = a11.getFileCharsetName()) != null) {
            return fileCharsetName;
        }
        String name = Charsets.UTF_8.name();
        Intrinsics.g(name, "name(...)");
        return name;
    }
}
