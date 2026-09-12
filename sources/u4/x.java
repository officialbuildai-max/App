package u4;

import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class x {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Mask a(JsonReader jsonReader, com.airbnb.lottie.h hVar) {
        boolean z10;
        boolean z11;
        jsonReader.h();
        Mask.MaskMode maskMode = null;
        q4.h hVar2 = null;
        q4.d dVar = null;
        boolean z12 = false;
        while (jsonReader.m()) {
            String q11 = jsonReader.q();
            q11.hashCode();
            switch (q11.hashCode()) {
                case 111:
                    if (q11.equals("o")) {
                        z10 = false;
                        break;
                    }
                    break;
                case 3588:
                    if (q11.equals("pt")) {
                        z10 = true;
                        break;
                    }
                    break;
                case 104433:
                    if (q11.equals("inv")) {
                        z10 = 2;
                        break;
                    }
                    break;
                case 3357091:
                    if (q11.equals("mode")) {
                        z10 = 3;
                        break;
                    }
                    break;
            }
            z10 = -1;
            switch (z10) {
                case false:
                    dVar = d.h(jsonReader, hVar);
                    break;
                case true:
                    hVar2 = d.k(jsonReader, hVar);
                    break;
                case true:
                    z12 = jsonReader.n();
                    break;
                case true:
                    String r11 = jsonReader.r();
                    r11.hashCode();
                    switch (r11.hashCode()) {
                        case 97:
                            if (r11.equals("a")) {
                                z11 = false;
                                break;
                            }
                            break;
                        case 105:
                            if (r11.equals("i")) {
                                z11 = true;
                                break;
                            }
                            break;
                        case 110:
                            if (r11.equals("n")) {
                                z11 = 2;
                                break;
                            }
                            break;
                        case INVALID_INDEX_URL_VALUE:
                            if (r11.equals("s")) {
                                z11 = 3;
                                break;
                            }
                            break;
                    }
                    z11 = -1;
                    switch (z11) {
                        case false:
                            maskMode = Mask.MaskMode.MASK_MODE_ADD;
                            break;
                        case true:
                            hVar.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            maskMode = Mask.MaskMode.MASK_MODE_INTERSECT;
                            break;
                        case true:
                            maskMode = Mask.MaskMode.MASK_MODE_NONE;
                            break;
                        case true:
                            maskMode = Mask.MaskMode.MASK_MODE_SUBTRACT;
                            break;
                        default:
                            v4.f.c("Unknown mask mode " + q11 + ". Defaulting to Add.");
                            maskMode = Mask.MaskMode.MASK_MODE_ADD;
                            break;
                    }
                default:
                    jsonReader.x();
                    break;
            }
        }
        jsonReader.l();
        return new Mask(maskMode, hVar2, dVar, z12);
    }
}
