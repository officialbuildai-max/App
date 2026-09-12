package js;

import com.transsion.shorttv.bean.Media;
import com.transsion.shorttv.bean.ShortTVItem;

/* loaded from: classes7.dex */
public abstract class l {
    public static final boolean a(e eVar) {
        ShortTVItem d11;
        Media video;
        return ((eVar == null || (d11 = eVar.d()) == null || (video = d11.getVideo()) == null) ? null : video.getVideoAddress()) != null;
    }

    public static final boolean b(e eVar) {
        Media video;
        if (eVar != null) {
            ShortTVItem d11 = eVar.d();
            if (((d11 == null || (video = d11.getVideo()) == null) ? null : video.getVideoAddress()) != null) {
                return false;
            }
        }
        return true;
    }
}
