package zzl.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

/**
 * Class <code>Object</code> is the root of the class hierarchy.
 * Every class has <code>Object</code> as a superclass. All objects,
 * including arrays, implement the methods of this class.
 *
 * @author Administrator
 * @version 1.0
 * @see
 * @since JDK1.7
 * <p>
 * History
 * Created by Administrator on 2017/2/21 0021.
 * 图片与Base64编码
 */
public class Base64Image {

    public static void main(String[] args){
        String str = "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCADcAYcDASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwDMlvZldd8jMMcZ6VWubp5XDBsmiVlbpnnrmodvSqUEjyOdlvTdRlspSQOvWrs1xBqMTOcJKO9Y+SvFJjqVyDQ4Ju5oqrSt0ILqLbJhSCB6VCEJq6rddyBgQRj0PY0R27nkLx61pexDZV8s5yRSrbvJIEjQux6BRmrnkkHBFXE02Y24uFUFQeR3o5rbgk3sZBj5xzjHcVIls+wvsYrnqBW/a6IZI982Rnpir8UEVivkN8wPc1nKqtkbRpN6s5exMVvP5jAkjpW7HqsJ69+2ad/ZNhIzDecsc8HpTJvDkTN+4mYfUZAqJShJ6msFUitC0L62nUKzDPapYpLbcdwQnp71hy6Lc2o3bxuU9BVZXkYqFDBs84peyT+Fmn1iS+JHUyQWk0RUwoQevGaxbvSLNzJ+5Vd3A2jGKrJc3loxG4kdSGqWPU3L/vFJUnqBQqco7MbrQlujNfQId+BIwA9utQXGiGGcCMl1rfd45Gz69angWNfr7mq9pJbkcsXsc3c6avkswUb1PO3pis/ycHlciu0urWMxhlfZnrWc8ESgH92zA44GKuFTQmUNTmCmKd5Wema6mLS7S9XmLY47g1Um0to5gmAMdDWiqpuxPI0rnPmOk5HetyfSHRNylX9RWZJbsjYYYNVGSZLTW5VZmbGT0phBJ55q15R9Ka8bEknHPPAp6AVvun1pjO3Y1YMZ/wAimGM0tAuRo7ZHJ46UrkkNjv1p4ixSmLNILlQrTWTmrflU4w5GcUXAoiNirYBKjlqb5RrRS2YjGKU25HanzAUo48DkZ9jQ0eaupF1FI0PA47VLYGe0WOMVCUIrRMdRNFlsYouO5Wjj5zirUagctT0iAGO1Mm4yB07VL1GMaTexPQCprd0UNI3SoCgC4/OmEnaV7Umrght5c+exCgjnrntWa2Rmrbj5jioSBu5GauOhSK5FRVdlRGx5SMo2jO5s5OOT0HGe1NEHy81RomUiKZirDJ82CKTyeOtBaIVQucDH4kD+dFSFQvbNFID1Fo1J4rR04WSOPNXGO55Bqs8bBsFSD6UAHFYNXVjy4S5Xc6gWFldICY1YEcHFQv4es5G3AsrDoaybW8mg6HIHY1dfVnYAqu1vY1g4TT0Z2KtSkveRSk8PzQzFkcFe1Q3FrPZEF0yCOuK1U1GSd0QKSTxwKty2puEId2zjGCKrnkn7xPJCS9w5gu0rIdn3eBgVow3NxJGBHGxwegq02jzRIWXBGegq7HttrUloVDDqacpxewQhJPXQyIru5kYwom1j2JqGZp1YrMMNjo1av2mFzu2+27FXDHb3sHkzDkj5W9KXNboPk5tFI5dZdrbgPmHSrUF7OsgJYYJp17pUtrJhD5idiKS3ULxKpCn71ae61czXNF2egTX7yEgqQaiR4w2So3ewq5PYo/zQyZ4zjHaqYhcNwp/KnFRtoEpST1JZnEq/dXpjB9Kz/s+G4GK3ItP3Iu4EMRmoGtih5FOLS0Qpcz1ZlvAWUHoRTQjocgnNaZi9qjaEU7iKDSykYPNQkHJJrQaD2phtzjOOKpWHdlNHkiOUYg06S5lk+8cn1qYxe1J5LEYA60WRSkyuJpB3z9ar3BEuCRj6VcaAqcEVE8VWkhczM1kG44Bxnjmh4ihxgZ9jmrbRc9Kb5XtQ2FyiyEMQRyPTmk2Z7Zq4YuaUQD8am4ygY/aniPjBFXGhIxwKkhtfNPNJsLGd5R6hatW9uHGMc1rJZDbgCrMNgF5xzWUqhXKZy2gC/dpDZ5/hrZ+zY7Uot6jmK5TnjYdeMVXks5OcCuoaFageNM01NhynJSW7pncKj2KQeDnsc8V01zDD5Z3YArEeIK52cjNaRlclqxU8o7GbjAIHXn8vwqvInNaJj46VWMWW5FVcCmykdKrvkGtJ4gM+1VzFk5NO40yjsPU0xoxyavtF7VG0J9KLjuZ7g4qJpGAxj8avPFjORVZo8kZq7lJ2K0m/aGKkKehI61GGYDg1d+zszHA4qwtpEoyeoFHMh85lGX1Wipp413naOKKC1I9lgLXNysYAJPGfatOXQYha/KpMmOuap288UMwdcA961BqiupGcGuCTlf3Tlp8lnzHPyWhhBB6g0wRknA61rGRGZg4BGc1EY4RKG52+1aKT6mLir6Mr2cps7kO0eT0+ldVlZY1cYIrnW2A7hz7GplvZAAE+UDg1nOPNqjoo1VDRmy6qRw2M9qreUrI8Ui4Dd6W2ZbiDIYZBxUsjBBiTsKys1odd1JXM2eKC3sZU8obgRhu9ZgupQAq9umKv6lJvRQrZB61mbTmumC01OKpL3rRLH253Xay5980gZzyR8tQhKsKPLyuQRV8q6E87e5HG/lyZUY7Yq/DLHgnA5/Oqfl7mJqdI/ahpMcZNElxKzldnGBiodxP3hknuan8v2pNnPSlokDbbuEdpHNzvbPoBSS6aw+4cr/tcU9MocirAuTtwefWovK+haUWtTIaEo5UjBFO2DbjFaEvly84w3c+tV9lap3IatsUmgHpUf2f0rS8vilEAOCau4rGU1sQcHjnB9qgeD2rba2GeKgkt8dhTTE0YrQe1RGCtlrf2qJoPak2K5lmEkAYHHtSCEjPHWtPyPajyBmo5ikZhg+lEe6JsgD6GtNrdSPeoXt8HilzXLCG8QHDoR7iplvoge4/Cqhi9qVBtPIyKlxQ+ZlsahEWIOQPXFK1/CEJDiqEmC3C8VBIm48DFHIhqQs2ozSN8mFFRtfShQMAkdSe9IIs014hxg1dkPUhmkaZss2fbtUYXH1qfyqPLphYhZBioDFuYLkDJ6npV3bxUbR1NxWKDx8cCoWjx1rSeIY5qBk4JxTTJKWwdDUyRK2PWkKDPNXbdFkORjim2NMpS2YboBVCawdTlQDXQuuTn0qFoA+e1SpFHP+UyDB+tVpZfLBUZye9dBcRKV2qOO9YU1oVc7uFHUjmtItMChK2eKKGGDRWqNEesCpVY03bjkYIpyrx2rmPMJlbPWpVb0qBc4qRQakaJhTgvFMXNTKKRSHozJ93inl5JDljntQq1MqdKl2NFJlV4t3UVCbfB6Vq+WDzTfJyaaYtzNEB9KcIsdRmtDyMdqPJ56VSkNIppDzirCQ8VOsXNTBMChstIqGPAppXmrbJUJXFK5SRCRTGUVOVNNKUkOxAR7UBKm20u2tEw5RipyMipAlORSTUu0jqKdw5SDy6Y0We1WwvtmkKZ7U7ktFBoqiaHNaZt8rxUJiIPSs2ybMo+QcZxxTTDitDyvammGpuCM5ocHBqJouK02hqBouaVx3M0xVGYq0mhyc00w+gPvVJhczGhqIw1qGGm/Z/anzDRnCEZ5FI0CsTgVo+R7VG0ODRc1TM025Bxio2irSaPIqJos9qdxGcYzTSlX2i9qaYfalcDOdPaq7oRWlLGfSq7R8cihMgzzEMUAiBz5ZYggZzxzjn8M1bMQxjnntSpaq3ByPeq5gsNt5hcMUZcGpzanmmCxUPuSQqR3FSG6eNQMA44JNQ2nsUrorG1xnNZV/aqoyehrakv4Q2D+dY2pXYnBjQfL61cL3AyXs1xmikYunRuKK31KTPSxUijilRMjNPAFc1zgsySNcnjHTvUoWmIKsKuaTZSiNVOamRKVUqdENS2UoiInSrAjIA4p0cdWVX1HFS2WokAXjpShcVP5YpCvtSuUokeM07YCelG2nYIJByKq5SQnl0uzFPFOxkUXKsV2X2qFlq6VBqJ0obGkVQBQVqYJzTtlCY7EAjB7UohOM9qsotSeXkVdyrEEMPfFWxbqR0pEQqOKnBBUDBBoKRELQHpQbXHatGFR5QqN2UHpSuHKiiYO1QtbsWIxx9KuPMqHmpoyjjPFRJkuJktbMO1NMGeBW40aleRUJt168VNzNwMVoMDpVdoeelbskI7AVWNvntS5iXEyfI9qcLbd1IHvWn9l9qU22B0p8xNjGe3Gab5HtWnJDjtUXlYp3LijPMNQmHPatUoCvSozDntRzF2Mpofaomt61mt89qjaD2o5gsZJhzR5Ix0q88JBqMxHFPmHYzZYVGc1SlB6AHH0rWkT2qnKXHTihMhlIK46R/nQWCfeIB9qSUOxOXaqxiNVYXN2JJLhQMKKozSls8VOyVC6cVSSRLkyi555UEVXlVT0GKuSJVd0rRDTKMkWaKsstFXcLnoYtp06rx1pyxMWGehqS2v96DcR+NWd8bcgLn2NcfOzX2CexEsOPusGH61ahi4ORn05qNBEWyG2n61OqkHAOQaXOL2JMkWPSpkjFRRBsFT+dSgsmMnpU8w/ZE6R471Mij1qOGaKYfKeR1GasJtBByKlzKVIQrj6UxgPWpnK8kH8qgBjk5BoUh+zG0uO9SCEY4agoVHXNWpIXIxoFPC8UgU04Zp3DlDbTCnfFTAkU7g+lS2WoFURe1O8o+lWgq+lSbAaakPkKixVKkftmp1jFSBBVcw7IhEXGacsXzc1PtFKq80OQWQbNq45FVZQR0q+cEVWlXOaaZLM1kJapYVKmpvK5qRIwKmUieVi7m2YphBJqcJxR5eTUXFytkG0mgR1Y8oU8RiobDkKyx+1PaLjpVpYxTvLB7UrhyGTLAM9KgMHtWw8IPaojAPSq5gUDJMHB6Uww1rG3FMMA9KXMUomV5J9Ka0PtWr5Q9KY0QPalzFcpjPbg9qiNsK2jAvpUbxDHSjnE4nPTW454rOnh9q6SaIc8VmzwjmrUjCSOfkh9qrNEQcgVsyw4qq0We1aqRnYynjPpUDRnPStR4arvDzVqQ7GXJHmqskZ9K2GQZ+7moJVz/CKpSCxjOntRVt4znmir5iWUY9XYYG+RR7MasvrshQL5zkVENJRWySRmpm0yLaBzn1q24G9pFi38TzRrtyD7kVrWfi2QHDqpX2rnDpRdsIM/Q1PDo0ucY5+tTKNNlJzR1MPidftGSjBD1INa51q3e3MiS7yoztxjNcbDptxDyFz+NWYYLonayYB96wlCHQ1i5dTdg8UW6zHMZXd3x0q4+vmYBYmGa51tJ+bKZPqDUR025Rt0LhT6UuWmyWqi0OnTVbqHqpYY71Yg1SVyMovPfFcv5GpyqqvOpVemT0q3a2l4mf3sWf940nGI1GZ20FxlMt39KkadWFYNrc3EChZnQ/nV37WjDnH51lazNuQviUZwaf5gxVBWUnIYmn7wD1p3DlRc8wUok5qj5vPrUyOT2pXCxdR6nVuKoqxJwBU6MR1qiGi6uMU8VAkg9amDKe9NEj8UUmfcGgGhgOpjU+mE80xDMCnDFJxR+FZtjJBSg80wdKXNAEuBTwoqFWqZTWbEPAp2KVRThSJIyuaaY6sbaNtAXKhjqNkq6yjFQMKVx3KhSmFKtFeajZaVx3KhXFRSDirbJxVdwaCWzPmXrVCZOPeth0OeRVOaEHoKakZtGLJHmqzRe1a0kPNV2gNWpEWMposA479aryRcGthofaongAHIq+cdjBkj61Vkj9q25EQE5FVpGiHSOrUwaMR4Se1FaUkqsxIjUe1FVzsmyKcLRGMed5RJ6CmyTWUROE3N/d5xTQtnu3nj1BPSiQWBGQQcehrflV+pvzMgnuCoHkr5an+7nNPi1XZt81N4Ax1pyjT3BBkcemTUscGlFSGZm9DmqajazQrvoyY6rG0XyBV98j+VN/tjaCoHOeGpo0zT5OVlkUdsHNL/ZFsG4uG6ZGcVHLTL5pl2DUivLtuB9BinnWIUY7o8n2rHuEih4W4LY9BUAKswHmcd8ij2MXqHtZLQ3l1xG+7b8n1NWbbUSzfNCNvbmsWEQggbufpmty2tSFUhkIPsBUThGJcZyZfW5tpV+dSp9qWO4t3fZ+9+pqtHdwxTFHHI6nAxV+DUbWRwhAGeh21k4tdDVTT6kyRqD8sjVKvnL1cEU8eWH25AJ96e67RnIA9cVnc0Gqxz82PyqZGx0H6VTedOgnRfrU8O5uVlVhjsaEiHYm8x85HFSJPIDyOKiHmbuxFSK+PvMBVidi0kwOMipln9qqrKo5DrUqzx9C4qkjN2LInNPE2e1V1ZGHGPyqVVGOKli0J/N4pvmCojmq7yFTSbBIueYKUSLVATbqcJMng1Fx8jNAMuKCRjrVVWI7801pH69qpvQOQuoy5xVpAvrWPHPtbmpBqHYVk2HIzaLDbwaaje9ZP23jrU0d4MdaVyXFmqHFLkVnfax60oux60XFyl1zxUDdaiN2tQtdL61IWLJxUbYqq10PWoXuh60gLZqNs+lU2uQT98fnUTzk/wAWfxoFcsyH1FVZCOaha4I65qFrkUiGx7kDPFQMR6Ux7getQmcetNMlse59BUEgyKGnFRGYdzVJklSdOtZ8qnJrTkZSOtUJcEnBq4yApOlFTlAaKrnCxyslldIRvxz3zTVtJieq/nU8WqnbtcBxStfpx5Y2t616qcuxXJEg+yyjqVH40eRMBnbkexqf7UrA+YQxJ61FLds54YBR0AFUricUSwz3UXyomMetNf7S7ncGyfeltrwCbdIMg+oq/DNC+S5DN2I7VLdnsUo3W5m/Z7n+4T+NMIljbDKwNbi7SCSdvpWffKxAKsHx2HWiM7uwSppK5FG03UA4HeraXUy/xN+dZQldeDkU8TEd6txuZ3sbUcrtzyfWrcNwVcEttx3FYC3TAYzS/am9ah07lKdjrI9W8liyksT0yadJrN0U+/gH6VyYuW9aU3TetZ+wRarM6EXJlclpAPU1t2up29tbhE+c9zjGa4VLog9avw3RAFKVG4Ko0dut8swEi7gR2BpkkjODtdAuc8nmuXivZNuATjNWobhi3Oaz9nylOpc34+oUyrU7SxRqcSAnpWA9wxYbc/jTDJIT0/Wkwj6HV2t+mACQPoavC8GMg8VxcJl8zdnA9BWsk/yjLHNYy3N4wuast0u/eCfzqM6grN1GPesqSfdkEnFQNfIhACgn1IqHqXy2NxLqMkkEU83AK/IQK5/7YgGGIP4ZxTDfqrAqR9MUuUrQ6L7UqsA02D3GKlF7HjAkBPvXLPqC44QH6moftqgYVHz6lqrkdibo6yW6UJlWXntmqvmMxyCBXLSTSyEAuQo6CrNrc+S2dzt6iodMXMdGHYjhqckkgOM1mwXib87WA9CaurcpnjNRZorRk7XLr1zSC+YdajM6EdqryXAGcAVIuRMtnUPemm9z3rIkmZj1pgZv72KdiXTNV70jvUTXue9Z7Fj/ABCmbSergU+UhwZeN3nvTDdn1qkyEH71MKf7Z/KjlRLgXTdn1qNronvVXb6NSeU3qKOVE8jJmuOKiNwaYYX9RSGB/alZE8jH+fk8tigun/PQ/lUYt3704W/rRZByETuexzUDA5q6IFPYfnR5CjsPzouHszPIb0oq6YV/vfnRRcPZnnWzbTg3tUkqEEDvSxw5OcV7HMPlGZ4pvJPB4qw0OO1KIiB0o5w5SAZp6kjoacy7TnFNLLjninzC5Rxmccbj+dJvbruOaaFDnHU1KqH1zT5gcSPLHqc0c1KUx2pAh9KtSIcBuSKUMaf5fy5puyjmQuQN1G4mjbijbRzIOQkj+8KvI2B1qiinNT54AqWyuU0oXGBzV2FsnrWPE+KvwS4xiueaZasa6AGnED1qrHISuaR5iO9YtNlRkkXVkC96GuB61ltcEHrUTXP1o9m2a+0RqSXY243VUNxk9aoPcU3z8CmqYOZeM7dqFdieao/acU5brmnytdBXRogmjLZ5NUjd+9NN170crC6L/mEHrThNjkmss3dBvDU+zYuZG5Hde9WFvD61zQuyO9O+3Ed6l0mP2iOl+3D1ppvFI61zP2589ad9vf8AvVDos0jUR0IuNx5K1Kjg85Fc4L9vWpV1H1zUOnIvnizoRKKDItc+NTJ4qQagTRysl2NppFNRF1NZQvckE1GdQyeaOViaRtK4p+8etYRvlHzdR9acmoqxpODFY3PM96Qygd6yUvlU5pz3aOPep5WJo0jKD3pjOvfH5Vjm8IOD+dBuiRVezZm2ajMOx/Soy5HcGsw3eO9Rtd570ezZPMjU3DuBRWSbo+tFHs2HMjn47pVwsi7gO/pVqOSF2BQn6VkGRicACpY1cfMAeOcivRcUVc2tyYwwpFCHIBqgL0kqkoB7ZqycAcVDVh3JZLZWYEHnFMayEijOAe9QG42N16UCUythSST0709RaEkEKo+DzjvSS8PkVG5lhGSuVPAOaaJFYrvnjTPTJo8wJg24cjmkD5fGKunTbiJQXXIboPWlXR7iWB5kMa7AThm5OPTFCmg5WVM7h0qQhcAjp3NTSWc9rGocKWJxhTmleylSMNJlcjOAp4+p7U+dBylYqOvao2UDpV37LIY2xjggZPHXpVSeC4jIHlF+QBs+bPftTU0KwxSAetTHtzTILaZl3vC8YDbcuMc+lWGtZEbDDBHY0+ZCsRoSKuW7kMKiWI+tSoMUm0yHE1opQqruHao5ZVJOBUMcmRg02TaOc1jbUSiwYg00r8tRFsnC0N5qfe3KPpxV3LSFaMim+UWXigSsejA/Wmm6EZweTnk+1F2VYTyiATikEftU4cMucjB5FIHAY5Ix2pczHYhlG1QR1zURJOaL2QYAU/UVD5uBmqTdhWHE4PNLwehqq8xJ4NQtMwHB5qtRWRoKNw4NIQwqgkjsch8YpzTSZHPT0FGoWRbOaTJFEb5TJ6dKDyOKVx2FDmnBzUIDE4FX4IAQARk0pNIEiv5pB608TEj7wq41gpPKdaYbFF+6tReLLsyuzsRndxURkJ4x071dNuvlhccVWa3CDbkmkrBqRhmwcVGWYHINTcxghFGT61AqOWxj8apJCdx4nccE1KLglaqSrscqRTVJFPkQrsnlunTpzUsV0+0cdaznY556VPDPGmASR9RScVYCzNLyCOpqAzH1qGe4B3EYwPXiqX2sFgCOp4pxiQ0aPn89aKqhXbBCt9dpoo5UFilDNGxBOFZcAg1JNfSxgKMFAeo6c9v0qMy2m4PtbI44I/wpk8kTn90pRR69SauxRHKTy+7DK3T+tW0upPKUH73uarW9jcTYDDG7lcHnHrXRWsaWcbIsYkXGCcZz9aTkkNIx2WQkF2NPhluLcloZCpPfHNax3sd6xMpxxtU4/E0wxRyqvmAh8/d2Yz+NLnHYoJJdJzvVuc7W5yfenAXEwdFhgj3Hqy/dOSePzq+vyHYiR4J5DgHFWWLIoZo451XsVxj6VLkFilbXur2drLEsSvGo2bjkgD25qNdc1CAAm3jVDnbuQ4A7gHNWrjVZbl0RYo0RPuoc4BqNVQuwVIxIedhPyk+oH+HrR6oCldeItRuWLRwxKVGWwhbI96R/ED3MkCTs0kW7BRhyPf8AA/yqb7BJE0jInllnBw/T3H54/IUs+nIrm4ZkcnO7YmMH/DrzTvELMs2uoXbXKr5u+KV9pR8E9yOSee/51I+qRSF5bXeZAGAG3BzwC312j/PeKPTvKj83CSYPzx8gKvTH5Vb0u4tIXjjmiHy/NDLtycHkgn1qHboUaMkbLC5nMRBZCNoOSBnt69PyqrKzNeASMVTAySRyCcD+X459qmuWMd0JQm+ByCOR8rDHUemffrRe2w1Las7SW5C5BUg9iAT19TUoCKeB7ZsN0PRvWqxf3rVTENskE7rKmMZBzt9R/kVmrbuJPJfnP3XGMN/9eqUiWipFqIaYg5CDp6ketXC2/vkVMscYQ/JggEBscg/5NV5JB5uSojjKjA6fN3x7U73YrDHV1YYkCqSBnqafJfTYeCRxKiY+cgjb2/HntTRknhwMcgkUw225HlZ8ZG4Y4yQc5NGnUaI9kyM0m5WDHIK9MUxiWGSaBJLGS8SkRk9AeM9+KkZJJ03rA/4DiqTERrN5Yx2qGW5Yng8UwxzMcBcn0qBg6nDDBq0kIlMpbk0hcmovm9KGLAdKdgHkjFQu2OScClALDe/EY5PNLZLLqmsQW0IPkhgzHGMD+9+Hai9g3NSx0t5oPM2fKWHznoQR0H07n8KfqdlBp626+YS0p5fHyqK6crDbQ+TEFSJBhVHasC9vGh1IO6qVEeyND13Z9/oPzrnU22aWSI9/kWixQRZkYZZx1OOmQehyDxUsGlhYx9ocJkbj3I9s5rBu7qQaszQhw+0biDnDf078f/XrditI72za7M0nkyplEZiCpxj8eab0EtRUhhViscqkZIyevSo5ZpLRkDkKjHHmYyBVPT70tZeXdPIJwxACoNuBWipe6VoSV8sjGCMA0PTcPQlg1JH2lZVkGKS512ys3CXT4ZudqLnaPU1zOpWkljcAxbkR+VPQD1rPBYCVmO8uMMSOeuc8/SrVKL1FztHeCWC6gE1tIroe4NZMk8n2+O3wAXOATWNpd/Jp6nyhlG+8p9fWtJr6O8IkKbZE4BNTyOLHzJmhOFVvLUhpewWq08ogj3MjFsE7VwTx1qnJcRwJ5kzcY4Udz2rJnvZZhNMoKx5VXZecjqMU1FibOseziuLdJYJdwIz8wwRWI1wqNtdSrZIAJ71Xl8StDpsVlaKUCry5OT69/wDPFJolkdUMl3cTvlHAGOucf/qppOKuw0b0L8trMdPF2rgBvu7TnIzjoeCfb+tWItOm2lLyTnG4ckZGPTPHX9K0p9Us7SyLTlcbyFjC5O4HP8+c1y+peJpZZD9nXYD3bk1MeaQ3ZFq0SK91NYyglhZjGkS9QP7zHg+nNWdTtVsUhs7INDcSMyh35OOpOR+mO1Y/h5WudTJFx5cjKxLYySOOOvfP6Vf1C4kutZMVntLovkoRyFJyGP6mm171hLYjknm0+2t3gZ5ZGBEi5PDZP+fyoq7HEsEhS2P3M5duTnP3ifU8/hRRddh2MO2tWupdkSL6kngCtdPDkZ2yPcq2052ldoNUI9Qs4Y1UbAQAWdOST2pJPEcqQGNSDkY3M2fxAHem3J7ArI3fs6LMfnDFQAGA4/zzUoiXODMyk4yAnT9a5ttTCWqzeashzgKF6Hjqfx9O1S2msoVJKh0/unqP8KnlY7o6Yj5wFmMg9CuMVcSQeXjZ09WFca+v5lKlG8tTlQW6+59asrqwnJAlEaKAShIBz6fSpcWO50eLFJd0sTo3qD/U8VHcMsinyJi+eBwAR+XWsOLXJIJAkZhbkZJjHA/ChvEDCRsHeemcDH4CjlYro10toYo1PkozHlmc5J/OoZHs5CBMirjoT0rHfxFeK2ckJ6bqH1+GY/vIfmPGfT3wKfLILo6ArZrtZJCoPHyEkfrUixjgyR+bExwG+6TXIR6s6l0SVwByAefzqT+2J3jaZLgrgHcqt8w/SjkYXR0Uha0uDg7VbhCORj09Kq5TczEhUY4YdlrAGttauZIJWYsdz7h97p/hT/7dW46RKpP3jzgevA60+Viujo4i6vJGTvC8EHODmrEVzLbgFTx6dRXMW+pTQtiOa3kAwv3iuR+I5FQnW7p5n2y+VkfdTBH/ANf6UcrYXO5a9WYbTGqt6qf6VDGLeSX5lzyCBnGfy/xrjYteuI98UqrKT0YLgj8P6cVqWerrNGY7eNGb/pooLA0nBodzfm3CclF3Ln7nOQPUj/8AXVO9WW72GBCjL7jn8KpPfLZxlpL0O4OW2rnA4yO+OeKozeIsSOyxqU6DACkUJPoJluSPUY33Osn4LxT1urp49uVK9Dlf/r1mp4nWaIxzAx4OdyjJb6ncP0FQx3KXMuI2JQDPDlSMDJPT8KvXqibdjY8yQ9VX8uKa81woCqVC/wC7mqUd2Y51t5LjK9N78bT/ALVXpYZIRkvGR0+VwaNgLVpaXU0fmllxj+KLr+tQXFvcqcsIyPXysU2BrqU7IjIwHpnilkS4iIWQsM9jSu7jsVsN3VfwH/16jmUxIJHBCsMjIIDDHH50Ncny1lzls8L0H41TutQN03lrgKowXzjP0FUrisRbpr5TubZEo4AHBOeldNosc2nwmSR18+5wEyOFUDGfoB/Sufe6hjtlRRkYwR/P+X86dJqLzHzHkcsRgAcAL/hRJOWg1ob+r6rbWMOyBhJMeASc8+prKa4kjsZhcuJ7iZwEBAOFI647Y5rLj2XUyzyMRGM4Hfgj/E/lUkM1t5771I3Hsc/KDyPx6fTPrU8qWg7lzSY7hIjLIkZUt8yv/CMDn1//AF1cu12xrarcNucZKAkLGv8Ajz/Os2e/dSJIgC7fOwzkA9P04pGuTbgM3zzTdTnJx/n+VGt7gXkmct5FtEc5yXI6KBj9etN1DUru0eMs+Occ8/zqrLdukUruqosgACsM7u5/U1lXV5LdFDM+5BnA9KpRuJs2pdReWALIqMh5Hv8Ah/WodvmLny1VPUH/AD/Ks6K8iiiCLGGbux+n8qsxatMpOwR5xnA5OOOlOzWwi/BYzuu9YXPGcA44/KluY3tYQfs33+jN0A/rS23iCORfLaQBj0LqQc06XVHnVYMxtgjAyDwRjjP+eai8r6jsjGkKPCZpHLYwApPJ/wDrVQMrMxOcAnJXtU0k6qzjyg6N0YjBHPPSolERAcy4GcY2nOP5frWqZNhFj8zczNjj/IrotJBsGjVyqr5e+QsOATnj64xWHaeW97CmfkLVrXEoS9OHEm4ksp6Z6enTAFTPXQcdNRb5/tdvJeSkM7N5canr1/nWXZ2bXVwE/gX77Z4ApbiYu2UOSzHDHv6n9T+dXo7mK3toYoVzKQGY54zz/XBo1S0DcnvJbSMg28YWYZwccqPX8uPw/KG3uzpkavCu6eVd2SfujNV4hsul4Vl6MWP1/wAKpzzgzM6nIxsXnoBxmhLoDY2Sd3JLM3PvRUcSq7Zc4UUVpewrFYNg0rvkbABjrnvUNLSAerEcZ4NORioJU47GoqKALCzsGDE5I6H0q0LpGiZGRSx7kdKzjRSaHcumfygcden0pWvRg/KM+1UcnNFFkFyybpw+5SFOc8U1rhiSWwc9agooFckMxLZHHNOWRQOQCT61DRTsFx4cc9s04uBxz05qGiiwE27HXOKUyZPXIHr1qHNFAXJTKd24E5zTxdyBt6sVf+8DyarUUWAnNwzZ3ck9aDINuOSe+e1QUZoAnE7D0z64pqyOsgkVsMDkEVHRQBo2+pPFGY2+YN1yM5FWbS9kM626OGVjhdxxj8ayAc07pSshnUm7u7KXy/NRHIztEoFO/tefJEqxvk5YlgSfxrlCxPJJNKsjq2VYg+oNLlXULm3eXDSo3lFef4QKqwMzBY92zp0FVFvLhDkStn35oNzK0u9my2M5xRawFpgFuCJDlU5NRyT8EAkeoFRSFjlixJ4poHegBd7YPPP8qck+0hsdOnNMwMbexqqWOetO1wNCO7wQ7Dcc5b/P+e9BvnZ9/wAo2jCj2rO3E9+PSkzRZBcvXF/LcKqyMWC8Dmqu84HPAqLNL1OKYh+4nJzyaUyN6nPXOai70uaAHF2Y7mJJ9SacGDH5iQR3qOigCTd1yacHZQFUjg5BFQilx0oAeTxy2TTkmZOrZB6iowKTFAFxJ/MfAOCen0qdZyH2oBu9T/OsvvTg7AHB696TQy7cXPlqY42znkn1Pc1U8wnrUeaDTSESGRsYHTtRUWcUUAf/2Q==";
        GenerateImage(str,"d:\\2.jpg");
        System.out.println(GetImageStr("d:\\1.jpg"));

    }

    /**
     * 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
     * @param imgFilePath
     * @return
     */
    public static String GetImageStr(String imgFilePath) {
        byte[] data = null;

        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgFilePath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        // 返回Base64编码过的字节数组字符串
        return encoder.encode(data);
    }

    /**
     * 对字节数组字符串进行Base64解码并生成图片
     * @param imgStr
     * @param imgFilePath
     * @return
     */
    public static boolean GenerateImage(String imgStr, String imgFilePath) {
        if (imgStr == null) // 图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] bytes = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            // 生成jpeg图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(bytes);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
