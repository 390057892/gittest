package utils;

import java.util.List;

/**
 * Created by Administrator on 2017/5/16 0016.
 */

public class WeatherDaily {

    /**
     * HeWeather5 : [{"now":{"hum":"31","vis":"10","pres":"1025","pcpn":"0","fl":"11","tmp":"13","cond":{"txt":"阴","code":"104"},"wind":{"sc":"4-5","spd":"24","deg":"40","dir":"东北风"}},"basic":{"city":"北京","update":{"loc":"2016-08-31 11:52","utc":"2016-08-31 03:52"},"lon":"116.391000","id":"CN101010100","prov":"北京","cnty":"中国","lat":"39.904000"},"status":"ok"}]
     */
    private List<HeWeather5Entity> HeWeather5;

    public void setHeWeather5(List<HeWeather5Entity> HeWeather5) {
        this.HeWeather5 = HeWeather5;
    }

    public List<HeWeather5Entity> getHeWeather5() {
        return HeWeather5;
    }

    public class HeWeather5Entity {
        /**
         * now : {"hum":"31","vis":"10","pres":"1025","pcpn":"0","fl":"11","tmp":"13","cond":{"txt":"阴","code":"104"},"wind":{"sc":"4-5","spd":"24","deg":"40","dir":"东北风"}}
         * basic : {"city":"北京","update":{"loc":"2016-08-31 11:52","utc":"2016-08-31 03:52"},"lon":"116.391000","id":"CN101010100","prov":"北京","cnty":"中国","lat":"39.904000"}
         * status : ok
         */
        private NowEntity now;
        private BasicEntity basic;
        private String status;

        public void setNow(NowEntity now) {
            this.now = now;
        }

        public void setBasic(BasicEntity basic) {
            this.basic = basic;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public NowEntity getNow() {
            return now;
        }

        public BasicEntity getBasic() {
            return basic;
        }

        public String getStatus() {
            return status;
        }

        public class NowEntity {
            /**
             * hum : 31
             * vis : 10
             * pres : 1025
             * pcpn : 0
             * fl : 11
             * tmp : 13
             * cond : {"txt":"阴","code":"104"}
             * wind : {"sc":"4-5","spd":"24","deg":"40","dir":"东北风"}
             */
            private String hum;
            private String vis;
            private String pres;
            private String pcpn;
            private String fl;
            private String tmp;
            private CondEntity cond;
            private WindEntity wind;

            public void setHum(String hum) {
                this.hum = hum;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public void setCond(CondEntity cond) {
                this.cond = cond;
            }

            public void setWind(WindEntity wind) {
                this.wind = wind;
            }

            public String getHum() {
                return hum;
            }

            public String getVis() {
                return vis;
            }

            public String getPres() {
                return pres;
            }

            public String getPcpn() {
                return pcpn;
            }

            public String getFl() {
                return fl;
            }

            public String getTmp() {
                return tmp;
            }

            public CondEntity getCond() {
                return cond;
            }

            public WindEntity getWind() {
                return wind;
            }

            public class CondEntity {
                /**
                 * txt : 阴
                 * code : 104
                 */
                private String txt;
                private String code;

                public void setTxt(String txt) {
                    this.txt = txt;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getTxt() {
                    return txt;
                }

                public String getCode() {
                    return code;
                }
            }

            public class WindEntity {
                /**
                 * sc : 4-5
                 * spd : 24
                 * deg : 40
                 * dir : 东北风
                 */
                private String sc;
                private String spd;
                private String deg;
                private String dir;

                public void setSc(String sc) {
                    this.sc = sc;
                }

                public void setSpd(String spd) {
                    this.spd = spd;
                }

                public void setDeg(String deg) {
                    this.deg = deg;
                }

                public void setDir(String dir) {
                    this.dir = dir;
                }

                public String getSc() {
                    return sc;
                }

                public String getSpd() {
                    return spd;
                }

                public String getDeg() {
                    return deg;
                }

                public String getDir() {
                    return dir;
                }
            }
        }

        public class BasicEntity {
            /**
             * city : 北京
             * update : {"loc":"2016-08-31 11:52","utc":"2016-08-31 03:52"}
             * lon : 116.391000
             * id : CN101010100
             * prov : 北京
             * cnty : 中国
             * lat : 39.904000
             */
            private String city;
            private UpdateEntity update;
            private String lon;
            private String id;
            private String prov;
            private String cnty;
            private String lat;

            public void setCity(String city) {
                this.city = city;
            }

            public void setUpdate(UpdateEntity update) {
                this.update = update;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setProv(String prov) {
                this.prov = prov;
            }

            public void setCnty(String cnty) {
                this.cnty = cnty;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getCity() {
                return city;
            }

            public UpdateEntity getUpdate() {
                return update;
            }

            public String getLon() {
                return lon;
            }

            public String getId() {
                return id;
            }

            public String getProv() {
                return prov;
            }

            public String getCnty() {
                return cnty;
            }

            public String getLat() {
                return lat;
            }

            public class UpdateEntity {
                /**
                 * loc : 2016-08-31 11:52
                 * utc : 2016-08-31 03:52
                 */
                private String loc;
                private String utc;

                public void setLoc(String loc) {
                    this.loc = loc;
                }

                public void setUtc(String utc) {
                    this.utc = utc;
                }

                public String getLoc() {
                    return loc;
                }

                public String getUtc() {
                    return utc;
                }
            }
        }
    }
}
