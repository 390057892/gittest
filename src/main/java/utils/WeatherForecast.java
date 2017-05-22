package utils;

import java.util.List;

/**
 * Created by Administrator on 2017/5/16 0016.
 */

public class WeatherForecast {

    /**
     * HeWeather5 : [{"basic":{"city":"北京","update":{"loc":"2016-08-31 11:52","utc":"2016-08-31 03:52"},"lon":"116.391000","id":"CN101010100","prov":"北京","cnty":"中国","lat":"39.904000"},"daily_forecast":[{"date":"2016-08-31","pop":"1","hum":"17","vis":"10","astro":{"ss":"18:47","mr":"04:19","ms":"18:07","sr":"05:41"},"pres":"997","pcpn":"0.0","tmp":{"min":"19","max":"33"},"cond":{"txt_n":"阴","code_n":"104","code_d":"100","txt_d":"晴"},"wind":{"sc":"3-4","spd":"10","deg":"342","dir":"北风"}}],"status":"ok"}]
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
         * basic : {"city":"北京","update":{"loc":"2016-08-31 11:52","utc":"2016-08-31 03:52"},"lon":"116.391000","id":"CN101010100","prov":"北京","cnty":"中国","lat":"39.904000"}
         * daily_forecast : [{"date":"2016-08-31","pop":"1","hum":"17","vis":"10","astro":{"ss":"18:47","mr":"04:19","ms":"18:07","sr":"05:41"},"pres":"997","pcpn":"0.0","tmp":{"min":"19","max":"33"},"cond":{"txt_n":"阴","code_n":"104","code_d":"100","txt_d":"晴"},"wind":{"sc":"3-4","spd":"10","deg":"342","dir":"北风"}}]
         * status : ok
         */
        private BasicEntity basic;
        private List<Daily_forecastEntity> daily_forecast;
        private String status;

        public void setBasic(BasicEntity basic) {
            this.basic = basic;
        }

        public void setDaily_forecast(List<Daily_forecastEntity> daily_forecast) {
            this.daily_forecast = daily_forecast;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public BasicEntity getBasic() {
            return basic;
        }

        public List<Daily_forecastEntity> getDaily_forecast() {
            return daily_forecast;
        }

        public String getStatus() {
            return status;
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

        public class Daily_forecastEntity {
            /**
             * date : 2016-08-31
             * pop : 1
             * hum : 17
             * vis : 10
             * astro : {"ss":"18:47","mr":"04:19","ms":"18:07","sr":"05:41"}
             * pres : 997
             * pcpn : 0.0
             * tmp : {"min":"19","max":"33"}
             * cond : {"txt_n":"阴","code_n":"104","code_d":"100","txt_d":"晴"}
             * wind : {"sc":"3-4","spd":"10","deg":"342","dir":"北风"}
             */
            private String date;
            private String pop;
            private String hum;
            private String vis;
            private AstroEntity astro;
            private String pres;
            private String pcpn;
            private TmpEntity tmp;
            private CondEntity cond;
            private WindEntity wind;

            public void setDate(String date) {
                this.date = date;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public void setAstro(AstroEntity astro) {
                this.astro = astro;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public void setTmp(TmpEntity tmp) {
                this.tmp = tmp;
            }

            public void setCond(CondEntity cond) {
                this.cond = cond;
            }

            public void setWind(WindEntity wind) {
                this.wind = wind;
            }

            public String getDate() {
                return date;
            }

            public String getPop() {
                return pop;
            }

            public String getHum() {
                return hum;
            }

            public String getVis() {
                return vis;
            }

            public AstroEntity getAstro() {
                return astro;
            }

            public String getPres() {
                return pres;
            }

            public String getPcpn() {
                return pcpn;
            }

            public TmpEntity getTmp() {
                return tmp;
            }

            public CondEntity getCond() {
                return cond;
            }

            public WindEntity getWind() {
                return wind;
            }

            public class AstroEntity {
                /**
                 * ss : 18:47
                 * mr : 04:19
                 * ms : 18:07
                 * sr : 05:41
                 */
                private String ss;
                private String mr;
                private String ms;
                private String sr;

                public void setSs(String ss) {
                    this.ss = ss;
                }

                public void setMr(String mr) {
                    this.mr = mr;
                }

                public void setMs(String ms) {
                    this.ms = ms;
                }

                public void setSr(String sr) {
                    this.sr = sr;
                }

                public String getSs() {
                    return ss;
                }

                public String getMr() {
                    return mr;
                }

                public String getMs() {
                    return ms;
                }

                public String getSr() {
                    return sr;
                }
            }

            public class TmpEntity {
                /**
                 * min : 19
                 * max : 33
                 */
                private String min;
                private String max;

                public void setMin(String min) {
                    this.min = min;
                }

                public void setMax(String max) {
                    this.max = max;
                }

                public String getMin() {
                    return min;
                }

                public String getMax() {
                    return max;
                }
            }

            public class CondEntity {
                /**
                 * txt_n : 阴
                 * code_n : 104
                 * code_d : 100
                 * txt_d : 晴
                 */
                private String txt_n;
                private String code_n;
                private String code_d;
                private String txt_d;

                public void setTxt_n(String txt_n) {
                    this.txt_n = txt_n;
                }

                public void setCode_n(String code_n) {
                    this.code_n = code_n;
                }

                public void setCode_d(String code_d) {
                    this.code_d = code_d;
                }

                public void setTxt_d(String txt_d) {
                    this.txt_d = txt_d;
                }

                public String getTxt_n() {
                    return txt_n;
                }

                public String getCode_n() {
                    return code_n;
                }

                public String getCode_d() {
                    return code_d;
                }

                public String getTxt_d() {
                    return txt_d;
                }
            }

            public class WindEntity {
                /**
                 * sc : 3-4
                 * spd : 10
                 * deg : 342
                 * dir : 北风
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
    }
}
