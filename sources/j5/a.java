package j5;

/* loaded from: classes3.dex */
public class a {
    private k5.b a(String[] strArr, String[] strArr2, float f11, k5.d dVar) {
        k5.b bVar = new k5.b();
        bVar.f66776d = strArr[9].replaceAll("\\{.*?\\}", "").replace("\n", "<br />").replace("\\N", "<br />");
        for (int i11 = 0; i11 < strArr2.length; i11++) {
            if (strArr2[i11].trim().equalsIgnoreCase("Style")) {
                k5.a aVar = (k5.a) dVar.f66784g.get(strArr[i11].trim());
                if (aVar != null) {
                    bVar.f66773a = aVar;
                } else {
                    dVar.f66787j += "undefined style: " + strArr[i11].trim() + "\n\n";
                }
            } else if (strArr2[i11].trim().equalsIgnoreCase("Start")) {
                try {
                    bVar.f66774b = new k5.c("h:mm:ss.cs", strArr[i11].trim());
                } catch (Throwable unused) {
                    bVar.f66774b = new k5.c("", "");
                }
            } else if (strArr2[i11].trim().equalsIgnoreCase("End")) {
                try {
                    bVar.f66775c = new k5.c("h:mm:ss.cs", strArr[i11].trim());
                } catch (Throwable unused2) {
                    bVar.f66775c = new k5.c("", "");
                }
            }
        }
        if (f11 != 100.0f && f11 > 0.0f) {
            float f12 = f11 / 100.0f;
            bVar.f66774b.f66777a = (int) (r8.f66777a / f12);
            bVar.f66775c.f66777a = (int) (r7.f66777a / f12);
        }
        return bVar;
    }

    private k5.a c(String[] strArr, String[] strArr2, int i11, boolean z10, String str) {
        String str2;
        String[] strArr3 = strArr;
        String[] strArr4 = strArr2;
        k5.a aVar = new k5.a(k5.a.a());
        if (strArr3.length == strArr4.length) {
            int i12 = 0;
            String str3 = str;
            while (i12 < strArr4.length) {
                if (strArr4[i12].trim().equalsIgnoreCase("Name")) {
                    aVar.f66764a = strArr3[i12].trim();
                } else if (strArr4[i12].trim().equalsIgnoreCase("Fontname")) {
                    aVar.f66765b = strArr3[i12].trim();
                } else if (strArr4[i12].trim().equalsIgnoreCase("Fontsize")) {
                    aVar.f66766c = strArr3[i12].trim();
                } else if (strArr4[i12].trim().equalsIgnoreCase("PrimaryColour")) {
                    String trim = strArr3[i12].trim();
                    if (z10) {
                        if (trim.startsWith("&H")) {
                            aVar.f66767d = k5.a.b("&HAABBGGRR", trim);
                        } else {
                            aVar.f66767d = k5.a.b("decimalCodedAABBGGRR", trim);
                        }
                    } else if (trim.startsWith("&H")) {
                        aVar.f66767d = k5.a.b("&HBBGGRR", trim);
                    } else {
                        aVar.f66767d = k5.a.b("decimalCodedBBGGRR", trim);
                    }
                } else if (strArr4[i12].trim().equalsIgnoreCase("BackColour")) {
                    String trim2 = strArr3[i12].trim();
                    if (z10) {
                        if (trim2.startsWith("&H")) {
                            aVar.f66768e = k5.a.b("&HAABBGGRR", trim2);
                        } else {
                            aVar.f66768e = k5.a.b("decimalCodedAABBGGRR", trim2);
                        }
                    } else if (trim2.startsWith("&H")) {
                        aVar.f66768e = k5.a.b("&HBBGGRR", trim2);
                    } else {
                        aVar.f66768e = k5.a.b("decimalCodedBBGGRR", trim2);
                    }
                } else if (strArr4[i12].trim().equalsIgnoreCase("Bold")) {
                    aVar.f66771h = Boolean.parseBoolean(strArr3[i12].trim());
                } else if (strArr4[i12].trim().equalsIgnoreCase("Italic")) {
                    aVar.f66770g = Boolean.parseBoolean(strArr3[i12].trim());
                } else if (strArr4[i12].trim().equalsIgnoreCase("Underline")) {
                    aVar.f66772i = Boolean.parseBoolean(strArr3[i12].trim());
                } else if (strArr4[i12].trim().equalsIgnoreCase("Alignment")) {
                    int parseInt = Integer.parseInt(strArr3[i12].trim());
                    if (z10) {
                        switch (parseInt) {
                            case 1:
                                aVar.f66769f = "bottom-left";
                                continue;
                            case 2:
                                aVar.f66769f = "bottom-center";
                                continue;
                            case 3:
                                aVar.f66769f = "bottom-right";
                                continue;
                            case 4:
                                aVar.f66769f = "mid-left";
                                continue;
                            case 5:
                                aVar.f66769f = "mid-center";
                                continue;
                            case 6:
                                aVar.f66769f = "mid-right";
                                continue;
                            case 7:
                                aVar.f66769f = "top-left";
                                continue;
                            case 8:
                                aVar.f66769f = "top-center";
                                continue;
                            case 9:
                                aVar.f66769f = "top-right";
                                continue;
                            default:
                                str2 = str3 + "undefined alignment for style at line " + i11 + "\n\n";
                                break;
                        }
                        str3 = str2;
                    } else {
                        switch (parseInt) {
                            case 1:
                                aVar.f66769f = "mid-left";
                                continue;
                            case 2:
                                aVar.f66769f = "mid-center";
                                continue;
                            case 3:
                                aVar.f66769f = "mid-right";
                                continue;
                            case 4:
                            case 8:
                            default:
                                str2 = str3 + "undefined alignment for style at line " + i11 + "\n\n";
                                break;
                            case 5:
                                aVar.f66769f = "top-left";
                                continue;
                            case 6:
                                aVar.f66769f = "top-center";
                                continue;
                            case 7:
                                aVar.f66769f = "top-right";
                                continue;
                            case 9:
                                aVar.f66769f = "bottom-left";
                                continue;
                            case 10:
                                aVar.f66769f = "bottom-center";
                                continue;
                            case 11:
                                aVar.f66769f = "bottom-right";
                                continue;
                        }
                        str3 = str2;
                    }
                }
                i12++;
                strArr3 = strArr;
                strArr4 = strArr2;
            }
        }
        return aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0330, code lost:
    
        if (r22 == null) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0333, code lost:
    
        r2.f66790m = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0335, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public k5.d b(java.lang.String r20, java.lang.String r21, java.io.InputStream r22) {
        /*
            Method dump skipped, instructions count: 829
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j5.a.b(java.lang.String, java.lang.String, java.io.InputStream):k5.d");
    }
}
