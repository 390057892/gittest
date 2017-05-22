package utils;

import java.util.List;

/**
 * Created by Administrator on 2017/5/17 0017.
 */

public class WeatherSuggestion {

    /**
     * HeWeather5 : [{"suggestion":{"uv":{"txt":"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。","brf":"中等"},"cw":{"txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。","brf":"较适宜"},"trav":{"txt":"天气较好，温度较高，天气较热，但有微风相伴，还是比较适宜旅游的，不过外出时要注意防暑防晒哦！","brf":"较适宜"},"comf":{"txt":"白天天气多云，同时会感到有些热，不很舒适。","brf":"较不舒适"},"drsg":{"txt":"天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。","brf":"炎热"},"sport":{"txt":"天气较好，户外运动请注意防晒。推荐您进行室内运动。","brf":"较适宜"},"flu":{"txt":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。","brf":"少发"}},"status":"ok"}]
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
         * suggestion : {"uv":{"txt":"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。","brf":"中等"},"cw":{"txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。","brf":"较适宜"},"trav":{"txt":"天气较好，温度较高，天气较热，但有微风相伴，还是比较适宜旅游的，不过外出时要注意防暑防晒哦！","brf":"较适宜"},"comf":{"txt":"白天天气多云，同时会感到有些热，不很舒适。","brf":"较不舒适"},"drsg":{"txt":"天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。","brf":"炎热"},"sport":{"txt":"天气较好，户外运动请注意防晒。推荐您进行室内运动。","brf":"较适宜"},"flu":{"txt":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。","brf":"少发"}}
         * status : ok
         */
        private SuggestionEntity suggestion;
        private String status;

        public void setSuggestion(SuggestionEntity suggestion) {
            this.suggestion = suggestion;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public SuggestionEntity getSuggestion() {
            return suggestion;
        }

        public String getStatus() {
            return status;
        }

        public class SuggestionEntity {
            /**
             * uv : {"txt":"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。","brf":"中等"}
             * cw : {"txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。","brf":"较适宜"}
             * trav : {"txt":"天气较好，温度较高，天气较热，但有微风相伴，还是比较适宜旅游的，不过外出时要注意防暑防晒哦！","brf":"较适宜"}
             * comf : {"txt":"白天天气多云，同时会感到有些热，不很舒适。","brf":"较不舒适"}
             * drsg : {"txt":"天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。","brf":"炎热"}
             * sport : {"txt":"天气较好，户外运动请注意防晒。推荐您进行室内运动。","brf":"较适宜"}
             * flu : {"txt":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。","brf":"少发"}
             */
            private UvEntity uv;
            private CwEntity cw;
            private TravEntity trav;
            private ComfEntity comf;
            private DrsgEntity drsg;
            private SportEntity sport;
            private FluEntity flu;

            public void setUv(UvEntity uv) {
                this.uv = uv;
            }

            public void setCw(CwEntity cw) {
                this.cw = cw;
            }

            public void setTrav(TravEntity trav) {
                this.trav = trav;
            }

            public void setComf(ComfEntity comf) {
                this.comf = comf;
            }

            public void setDrsg(DrsgEntity drsg) {
                this.drsg = drsg;
            }

            public void setSport(SportEntity sport) {
                this.sport = sport;
            }

            public void setFlu(FluEntity flu) {
                this.flu = flu;
            }

            public UvEntity getUv() {
                return uv;
            }

            public CwEntity getCw() {
                return cw;
            }

            public TravEntity getTrav() {
                return trav;
            }

            public ComfEntity getComf() {
                return comf;
            }

            public DrsgEntity getDrsg() {
                return drsg;
            }

            public SportEntity getSport() {
                return sport;
            }

            public FluEntity getFlu() {
                return flu;
            }

            public class UvEntity {
                /**
                 * txt : 属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。
                 * brf : 中等
                 */
                private String txt;
                private String brf;

                public void setTxt(String txt) {
                    this.txt = txt;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public String getBrf() {
                    return brf;
                }
            }

            public class CwEntity {
                /**
                 * txt : 较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。
                 * brf : 较适宜
                 */
                private String txt;
                private String brf;

                public void setTxt(String txt) {
                    this.txt = txt;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public String getBrf() {
                    return brf;
                }
            }

            public class TravEntity {
                /**
                 * txt : 天气较好，温度较高，天气较热，但有微风相伴，还是比较适宜旅游的，不过外出时要注意防暑防晒哦！
                 * brf : 较适宜
                 */
                private String txt;
                private String brf;

                public void setTxt(String txt) {
                    this.txt = txt;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public String getBrf() {
                    return brf;
                }
            }

            public class ComfEntity {
                /**
                 * txt : 白天天气多云，同时会感到有些热，不很舒适。
                 * brf : 较不舒适
                 */
                private String txt;
                private String brf;

                public void setTxt(String txt) {
                    this.txt = txt;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public String getBrf() {
                    return brf;
                }
            }

            public class DrsgEntity {
                /**
                 * txt : 天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。
                 * brf : 炎热
                 */
                private String txt;
                private String brf;

                public void setTxt(String txt) {
                    this.txt = txt;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public String getBrf() {
                    return brf;
                }
            }

            public class SportEntity {
                /**
                 * txt : 天气较好，户外运动请注意防晒。推荐您进行室内运动。
                 * brf : 较适宜
                 */
                private String txt;
                private String brf;

                public void setTxt(String txt) {
                    this.txt = txt;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public String getBrf() {
                    return brf;
                }
            }

            public class FluEntity {
                /**
                 * txt : 各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。
                 * brf : 少发
                 */
                private String txt;
                private String brf;

                public void setTxt(String txt) {
                    this.txt = txt;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public String getBrf() {
                    return brf;
                }
            }
        }
    }
}
