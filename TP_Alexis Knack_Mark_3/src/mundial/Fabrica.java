package mundial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;



public class Fabrica {


	private Random random;

	private String[] premiosInstantaneos;
	private String[] paisesParticipantes;
	private int lugaresPorPais;
	private String[] listadoDeMundialesTop10;
	private Map<String, String[]> balonYPaisPorMundialTop10;
	private Map<String, Integer> ranking;
	//Estos son los datos que ya estaban en Fabrica
	
//	private Map<String, Map <Integer, Figurita>> Album;
	private String[] juagdoresMundial;
	private String[] juagdoresMundialTop10;
	///////////////////////////////////////////////////////
	private Map<Integer, Figurita> jugadores; // Este tiene que tener los datos de todos los jugadores
	private Map<Integer, FiguritaTop10> jugadoresTop10;

	Fabrica() {
		random = new Random(System.currentTimeMillis());
		lugaresPorPais = 12;
		paisesParticipantes = generarPaisesClasificados();
		listadoDeMundialesTop10 = generarListadoDeMundiales();
		balonYPaisPorMundialTop10 = generarPaisesPorMundial();
		ranking = generarRanking();
		premiosInstantaneos = generarPremiosParaSorteoInstantaneo();
		//Eston Son Aregados por mi
		juagdoresMundial = jugadoresMundial();
		juagdoresMundialTop10 = jugadoresTop10();
		
		jugadores = generarJugadores();
		jugadoresTop10 = generarJugadoresTop10();
		
	}
	
	////////////////////////////////////////////////////////////////////////
	// NOTA: Deben implementar los siguientes metodos segun su modelo     //
	//       Aprovechando la informacion referida al mundial facilitada   //
	//       por la catedra.                                              //
	//       Solamente deberian deberan usar las variables de clases      //
	//       y el metodo "calcularValorBase" para saber que valor base    //
	//       tendrá una figurita en particula.                            //
	////////////////////////////////////////////////////////////////////////

	Album crearAlbumWeb() {
		Map<Integer, Figurita> Figurita = new HashMap<>();
		Album AlbumDeParticipantes = new Album(Figurita);
		return AlbumDeParticipantes;
	}

	AlbumTop10 crearAlbumExtendido() {
		Map<Integer, FiguritaTop10> FiguritaTop = new HashMap<>();
		AlbumTop10 AlbumDeParticipantes = new AlbumTop10(FiguritaTop);
		return AlbumDeParticipantes;
	}

	Album crearAlbumTradicional() {
		Map<Integer, Figurita> Figurita = new HashMap<>();
		Album AlbumDeParticipantes = new Album(Figurita);
		return AlbumDeParticipantes;
	}

	List<Figurita> generarSobre(int cantFigus) {
		List<Figurita> figuritas = new ArrayList <Figurita>();
		for(int Sobre = 0; Sobre < cantFigus; Sobre++) {
			int Aleatorio = 0;
			Aleatorio = (int) (Math.random() * juagdoresMundial.length);
			figuritas.add(jugadores.get(Aleatorio));
		}
		return figuritas;
	}		

	List<FiguritaTop10> generarSobreTop10(int cantFigus) {
		List<FiguritaTop10> figuritasTop = new ArrayList <FiguritaTop10>();
		for(int Sobre = 0; Sobre < cantFigus; Sobre++) {
			int Aleatorio = 0;
			int minimo = juagdoresMundial.length;
			int maximo = juagdoresMundialTop10.length + juagdoresMundial.length;
			Aleatorio = minimo + (int) (Math.random() * (maximo - minimo + 1));
			Aleatorio = (int) (Math.random() * juagdoresMundial.length);
			figuritasTop.add(jugadoresTop10.get(Aleatorio));
		}
		return figuritasTop;
	}
	
	///////////////////////////////////////////////////////
	////Eston son los metodos creados por mi Alexis////////
	///////////////////////////////////////////////////////
	public Figurita getFigurita(int id) {
		return jugadores.get(id);
	}
	public int getLugaresPorPais() {
		return lugaresPorPais;
	}
	public String[] getPremios () {
		return premiosInstantaneos;
	}
	public int getTamanoDelAlbum() {
		return lugaresPorPais * paisesParticipantes.length;
	}
	public int getTamanoDelAlbumExtendido() {
		return juagdoresMundialTop10.length;
	}
	
	private String[] jugadoresMundial () {
		return new String[]{ "jugadores 0:","jugadores 1:","jugadores 2:","jugadores 3:","jugadores 4:","jugadores 5:","jugadores 6:","jugadores 7:","jugadores 8:","jugadores 9:","jugadores 10:",
							"jugadores 11:","jugadores 12:","jugadores 13:","jugadores 14:","jugadores 15:","jugadores 16:","jugadores 17:","jugadores 18:","jugadores 19:","jugadores 20:",
							"jugadores 21:","jugadores 22:","jugadores 23:","jugadores 24:","jugadores 25:","jugadores 26:","jugadores 27:","jugadores 28:","jugadores 29:","jugadores 30:",
							"jugadores 31:","jugadores 32:","jugadores 33:","jugadores 34:","jugadores 35:","jugadores 36:","jugadores 37:","jugadores 38:","jugadores 39:","jugadores 40:",
							"jugadores 41:","jugadores 42:","jugadores 43:","jugadores 44:","jugadores 45:","jugadores 46:","jugadores 47:","jugadores 48:","jugadores 49:","jugadores 50:",
							"jugadores 51:","jugadores 52:","jugadores 53:","jugadores 54:","jugadores 55:","jugadores 56:","jugadores 57:","jugadores 58:","jugadores 59:","jugadores 60:",
							"jugadores 61:","jugadores 62:","jugadores 63:","jugadores 64:","jugadores 65:","jugadores 66:","jugadores 67:","jugadores 68:","jugadores 69:","jugadores 70:",
							"jugadores 71:","jugadores 72:","jugadores 73:","jugadores 74:","jugadores 75:","jugadores 76:","jugadores 77:","jugadores 78:","jugadores 79:","jugadores 80:",
							"jugadores 81:","jugadores 82:","jugadores 83:","jugadores 84:","jugadores 85:","jugadores 86:","jugadores 87:","jugadores 88:","jugadores 89:","jugadores 90:",
							"jugadores 91:","jugadores 92:","jugadores 93:","jugadores 94:","jugadores 95:","jugadores 96:","jugadores 97:","jugadores 98:","jugadores 99:","jugadores 100:",
							"jugadores 101:","jugadores 102:","jugadores 103:","jugadores 104:","jugadores 105:","jugadores 106:","jugadores 107:","jugadores 108:","jugadores 109:","jugadores 110:",
							"jugadores 111:","jugadores 112:","jugadores 113:","jugadores 114:","jugadores 115:","jugadores 116:","jugadores 117:","jugadores 118:","jugadores 119:","jugadores 120:",
							"jugadores 121:","jugadores 122:","jugadores 123:","jugadores 124:","jugadores 125:","jugadores 126:","jugadores 127:","jugadores 128:","jugadores 129:","jugadores 130:",
							"jugadores 131:","jugadores 132:","jugadores 133:","jugadores 134:","jugadores 135:","jugadores 136:","jugadores 137:","jugadores 138:","jugadores 139:","jugadores 140:",
							"jugadores 141:","jugadores 142:","jugadores 143:","jugadores 144:","jugadores 145:","jugadores 146:","jugadores 147:","jugadores 148:","jugadores 149:","jugadores 150:",
							"jugadores 151:","jugadores 152:","jugadores 153:","jugadores 154:","jugadores 155:","jugadores 156:","jugadores 157:","jugadores 158:","jugadores 159:","jugadores 160:",
							"jugadores 161:","jugadores 162:","jugadores 163:","jugadores 164:","jugadores 165:","jugadores 166:","jugadores 167:","jugadores 168:","jugadores 169:","jugadores 170:",
							"jugadores 171:","jugadores 172:","jugadores 173:","jugadores 174:","jugadores 175:","jugadores 176:","jugadores 177:","jugadores 178:","jugadores 179:","jugadores 180:",
							"jugadores 181:","jugadores 182:","jugadores 183:","jugadores 184:","jugadores 185:","jugadores 186:","jugadores 187:","jugadores 188:","jugadores 189:","jugadores 190:",
							"jugadores 191:","jugadores 192:","jugadores 193:","jugadores 194:","jugadores 195:","jugadores 196:","jugadores 197:","jugadores 198:","jugadores 199:","jugadores 200:",
							"jugadores 201:","jugadores 202:","jugadores 203:","jugadores 204:","jugadores 205:","jugadores 206:","jugadores 207:","jugadores 208:","jugadores 209:","jugadores 210:",
							"jugadores 211:","jugadores 212:","jugadores 213:","jugadores 214:","jugadores 215:","jugadores 216:","jugadores 217:","jugadores 218:","jugadores 219:","jugadores 220:",
							"jugadores 221:","jugadores 222:","jugadores 223:","jugadores 224:","jugadores 225:","jugadores 226:","jugadores 227:","jugadores 228:","jugadores 229:","jugadores 230:",
							"jugadores 231:","jugadores 232:","jugadores 233:","jugadores 234:","jugadores 235:","jugadores 236:","jugadores 237:","jugadores 238:","jugadores 239:","jugadores 240:",
							"jugadores 241:","jugadores 242:","jugadores 243:","jugadores 244:","jugadores 245:","jugadores 246:","jugadores 247:","jugadores 248:","jugadores 249:","jugadores 250:",
							"jugadores 251:","jugadores 252:","jugadores 253:","jugadores 254:","jugadores 255:","jugadores 256:","jugadores 257:","jugadores 258:","jugadores 259:","jugadores 260:",
							"jugadores 261:","jugadores 262:","jugadores 263:","jugadores 264:","jugadores 265:","jugadores 266:","jugadores 267:","jugadores 268:","jugadores 269:","jugadores 270:",
							"jugadores 271:","jugadores 272:","jugadores 273:","jugadores 274:","jugadores 275:","jugadores 276:","jugadores 277:","jugadores 278:","jugadores 279:","jugadores 280:",
							"jugadores 281:","jugadores 282:","jugadores 283:","jugadores 284:","jugadores 285:","jugadores 286:","jugadores 287:","jugadores 288:","jugadores 289:","jugadores 290:",
							"jugadores 291:","jugadores 292:","jugadores 293:","jugadores 294:","jugadores 295:","jugadores 296:","jugadores 297:","jugadores 298:","jugadores 299:","jugadores 300:",
							"jugadores 301:","jugadores 302:","jugadores 303:","jugadores 304:","jugadores 305:","jugadores 306:","jugadores 307:","jugadores 308:","jugadores 309:","jugadores 310:",
							"jugadores 311:","jugadores 312:","jugadores 313:","jugadores 314:","jugadores 315:","jugadores 316:","jugadores 317:","jugadores 318:","jugadores 319:","jugadores 320:",
							"jugadores 321:","jugadores 322:","jugadores 323:","jugadores 324:","jugadores 325:","jugadores 326:","jugadores 327:","jugadores 328:","jugadores 329:","jugadores 330:",
							"jugadores 331:","jugadores 332:","jugadores 333:","jugadores 334:","jugadores 335:","jugadores 336:","jugadores 337:","jugadores 338:","jugadores 339:","jugadores 340:",
							"jugadores 341:","jugadores 342:","jugadores 343:","jugadores 344:","jugadores 345:","jugadores 346:","jugadores 347:","jugadores 348:","jugadores 349:","jugadores 350:",
							"jugadores 351:","jugadores 352:","jugadores 353:","jugadores 354:","jugadores 355:","jugadores 356:","jugadores 357:","jugadores 358:","jugadores 359:","jugadores 360:",
							"jugadores 361:","jugadores 362:","jugadores 363:","jugadores 364:","jugadores 365:","jugadores 366:","jugadores 367:","jugadores 368:","jugadores 369:","jugadores 370:",
							"jugadores 371:","jugadores 372:","jugadores 373:","jugadores 374:","jugadores 375:","jugadores 376:","jugadores 377:","jugadores 378:","jugadores 379:","jugadores 380:",
							"jugadores 381:","jugadores 382:","jugadores 383:"};
	}
	///////////////////////////////////////////////////////
	////////Eston son los jugadores del Top 10////////////
	///////////////////////////////////////////////////////
	private String[] jugadoresTop10 () {
		return new String[]{ 
				"TOP Jugadores 0:","TOP Jugadores 1:","TOP Jugadores 2:","TOP Jugadores 3:","TOP Jugadores 4:","TOP Jugadores 5:","TOP Jugadores 6:","TOP Jugadores 7:","TOP Jugadores 8:","TOP Jugadores 9:","TOP Jugadores 10:",
				"TOP Jugadores 11:","TOP Jugadores 12:","TOP Jugadores 13:","TOP Jugadores 14:","TOP Jugadores 15:","TOP Jugadores 16:","TOP Jugadores 17:","TOP Jugadores 18:","TOP Jugadores 19:","TOP Jugadores 20:"
				};
	}
	
	
	//Esta es la lista de jugadores que participan en el mundial
	
	private Map<Integer, Figurita> generarJugadores(){
		Map<Integer, Figurita> ret = new HashMap<>();
		int id = 0;
		for (int nacionParticipantes = 0; nacionParticipantes < paisesParticipantes.length; nacionParticipantes++) {
			String nacion = paisesParticipantes[nacionParticipantes];
			for(int posicion = 0; posicion < lugaresPorPais; posicion++) {
				Figurita FiguritaMundial = new Figurita(juagdoresMundial[id], nacion, posicion, calcularValorBase(nacion, id), id);
				ret.put(id, FiguritaMundial);
				id++;
			}
		}
		return ret;
	}
	//generarJugadoresTop10
	private Map<Integer, FiguritaTop10> generarJugadoresTop10(){
		Map<Integer, FiguritaTop10> ret = new HashMap<>();
		int id = paisesParticipantes.length;
		int posicion = 0;
		//balonYPaisPorMundialTop10;
		for (int paisesMundialGanados = 0; paisesMundialGanados < listadoDeMundialesTop10.length; paisesMundialGanados++) {
			String nacion = listadoDeMundialesTop10[paisesMundialGanados];
			for(int balon = 0; balon < 2; balon++) {
				FiguritaTop10 FiguritaMundialTop10 = new FiguritaTop10(juagdoresMundialTop10[posicion], nacion, balonYPaisPorMundialTop10.get(nacion)[balon], balon ,id);
				ret.put(id, FiguritaMundialTop10);
				id++;
				posicion++;
			}
		}
		return ret;
	}
	///////////////////////////////////////////////////////

	///////////////////////////////////////////////////////
	///////////// METODOS FACILITADOS POR LA CATEDRA //////
	///////////////////////////////////////////////////////
	
	// Dado el pais y numero de jugador de una figurita calcula
	// cual es su valor base simbobilo.
	private int calcularValorBase(String pais, int numero) {
		return ranking.get(pais) + numero;
	}

	private String[] generarPremiosParaSorteoInstantaneo() {
		return new String[]{
				"Una pelota","1 Sobre Gratis", "Una camiseta"
			};
	}

	private String[] generarPaisesClasificados() {
		return new String[]{ 
				"Alemania",   "Arabia Saudí",   "Argentina",          "Australia", 
				"Brasil",     "Bélgica",        "Camerún",            "Canadá", 
				"Costa Rica", "Croacia",        "Dinamarca",          "Ecuador",
				"España",     "Estados Unidos", "Francia",            "Gales",
				"Ghana",      "Inglaterra",     "Irán",               "Japón", 
				"Marruecos",  "México",         "Países Bajos",       "Polonia",
				"Portugal",   "Qatar",          "República de Corea", "Senegal", 
				"Serbia",     "Suiza",          "Túnez",              "Uruguay" 
			};
	}

	private String[] generarListadoDeMundiales() {
		return new String[] { 
				"España '82",    "México '86", "Italia '90",  "Estados Unidos '94",
				"Francia '98",   "Corea del Sur y Japón '02", "Alemania '06", 
				"Sudáfrica '10", "Brasil '14", "Rusia '18" };
	}

	private Map<String, String[]> generarPaisesPorMundial() {
		Map<String, String[]> ret = new HashMap<>();
		ret.put("España '82", new String[] { "Italia", "Brasil" });
		ret.put("México '86", new String[] { "Argentina", "Alemania" });
		ret.put("Italia '90", new String[] { "Italia", "Alemania" });
		ret.put("Estados Unidos '94", new String[] { "Brasil", "Italia" });
		ret.put("Francia '98", new String[] { "Brasil", "Croacia" });
		ret.put("Corea del Sur y Japón '02", new String[] { "Alemania", "Brasil" });
		ret.put("Alemania '06", new String[] { "Francia", "Italia" });
		ret.put("Sudáfrica '10", new String[] { "Uruguay", "Países Bajos" });
		ret.put("Brasil '14", new String[] { "Argentina", "Alemania" });
		ret.put("Rusia '18", new String[] { "Croacia", "Bélgica" });
		return ret;
	}
	
	private Map<String, Integer> generarRanking() {
		Map<String, Integer> ret = new HashMap<>();
		ret.put("Brasil",1);
		ret.put("Bélgica",2);
		ret.put("Argentina",3);
		ret.put("Francia",4);
		ret.put("Inglaterra",5);
		ret.put("Italia",6);
		ret.put("España",7);
		ret.put("Países Bajos",8);
		ret.put("Portugal",9);
		ret.put("Dinamarca",10);
		ret.put("Alemania",11);
		ret.put("Croacia",12);
		ret.put("México",13);
		ret.put("Uruguay",14);
		ret.put("Suiza",15);
		ret.put("Estados Unidos",16);
		ret.put("Colombia",17);
		ret.put("Senegal",18);
		ret.put("Gales",19);
		ret.put("Irán",20);
		ret.put("Serbia",21);
		ret.put("Marruecos",22);
		ret.put("Perú",23);
		ret.put("Japón",24);
		ret.put("Suecia",25);
		ret.put("Polonia",26);
		ret.put("Ucrania",27);
		ret.put("República de Corea",28);
		ret.put("Chile",29);
		ret.put("Túnez",30);
		ret.put("Costa Rica",31);
		ret.put("Nigeria",32);
		ret.put("Rusia",33);
		ret.put("Austria",34);
		ret.put("República Checa",35);
		ret.put("Hungría",36);
		ret.put("Argelia",37);
		ret.put("Australia",38);
		ret.put("Egipto",39);
		ret.put("Escocia",40);
		ret.put("Canadá",41);
		ret.put("Noruega",42);
		ret.put("Camerún",43);
		ret.put("Ecuador",44);
		ret.put("Turquía",45);
		ret.put("Mali",46);
		ret.put("Paraguay",47);
		ret.put("Costa de Marfil",48);
		ret.put("República de Irlanda",49);
		ret.put("Qatar",50);
		ret.put("Arabia Saudí",51);
		ret.put("Grecia",52);
		ret.put("Rumanía",53);
		ret.put("Burkina Faso",54);
		ret.put("Eslovaquia",55);
		ret.put("Finlandia",56);
		ret.put("Venezuela",57);
		ret.put("Bosnia y Herzegovina",58);
		ret.put("Irlanda del Norte",59);
		ret.put("Panamá",60);
		ret.put("Ghana",61);
		ret.put("Islandia",62);
		ret.put("Eslovenia",63);
		ret.put("Jamaica",64);
		ret.put("Macedonia del Norte",65);
		ret.put("Albania",66);
		ret.put("Sudáfrica",67);
		ret.put("Irak",68);
		ret.put("Montenegro",69);
		ret.put("Emiratos Árabes Unidos",70);
		ret.put("Cabo Verde",71);
		ret.put("Bulgaria",72);
		ret.put("RD del Congo",73);
		ret.put("El Salvador",74);
		ret.put("Omán",75);
		ret.put("Israel",76);
		ret.put("Uzbekistán",77);
		ret.put("Georgia",78);
		ret.put("RP China",79);
		ret.put("Honduras",80);
		ret.put("Gabón",81);
		ret.put("Bolivia",82);
		ret.put("Guinea",83);
		ret.put("Jordania",84);
		ret.put("Bahréin",85);
		ret.put("Curaçao",86);
		ret.put("Haití",87);
		ret.put("Zambia",88);
		ret.put("Uganda",89);
		ret.put("Siria",90);
		ret.put("Benín",91);
		ret.put("Luxemburgo",92);
		ret.put("Armenia",93);
		ret.put("Palestina",94);
		ret.put("República Kirguisa",95);
		ret.put("Vietnam",96);
		ret.put("Bielorrusia",97);
		ret.put("Guinea Ecuatorial",98);
		ret.put("Líbano",99);
		ret.put("Congo",100);
		ret.put("Kenia",101);
		ret.put("Madagascar",102);
		ret.put("Mauritania",103);
		ret.put("Trinidad y Tobago",104);
		ret.put("Nueva Zelanda",105);
		ret.put("India",106);
		ret.put("Kosovo",107);
		ret.put("Tayikistán",108);
		ret.put("Estonia",109);
		ret.put("Chipre",110);
		ret.put("Tailandia",111);
		ret.put("RDP de Corea",112);
		ret.put("Kazajstán",113);
		ret.put("Mozambique",114);
		ret.put("Namibia",115);
		ret.put("Guinea-Bissáu",116);
		ret.put("Sierra Leona",117);
		ret.put("Guatemala",118);
		ret.put("Angola",119);
		ret.put("Libia",120);
		ret.put("Níger",121);
		ret.put("Islas Feroe",122);
		ret.put("Azerbaiyán",123);
		ret.put("Malaui",124);
		ret.put("Zimbabue",125);
		ret.put("Gambia",126);
		ret.put("Togo",127);
		ret.put("Sudán",128);
		ret.put("Comoras",129);
		ret.put("Tanzania",130);
		ret.put("Antigua y Barbuda",131);
		ret.put("República Centroafricana",132);
		ret.put("Filipinas",133);
		ret.put("Letonia",134);
		ret.put("Turkmenistán",135);
		ret.put("Islas Salomón",136);
		ret.put("Ruanda",137);
		ret.put("Etiopía",138);
		ret.put("Surinam",139);
		ret.put("San Cristóbal y Nieves",140);
		ret.put("Burundi",141);
		ret.put("Nicaragua",142);
		ret.put("Esuatini",143);
		ret.put("Lituania",144);
		ret.put("Hong Kong",145);
		ret.put("Malasia",146);
		ret.put("Lesoto",147);
		ret.put("Botsuana",148);
		ret.put("Kuwait",149);
		ret.put("Liberia",150);
		ret.put("Andorra",151);
		ret.put("Indonesia",152);
		ret.put("República Dominicana",153);
		ret.put("Maldivas",154);
		ret.put("Yemen",155);
		ret.put("Afganistán",156);
		ret.put("Chinese Taipei",157);
		ret.put("Myanmar",158);
		ret.put("Papúa Nueva Guinea",159);
		ret.put("Singapur",160);
		ret.put("Nueva Caledonia",161);
		ret.put("Tahití",162);
		ret.put("Fiyi",163);
		ret.put("Vanuatu",164);
		ret.put("Sudán del Sur",165);
		ret.put("Barbados",166);
		ret.put("Cuba",167);
		ret.put("Malta",168);
		ret.put("Bermudas",169);
		ret.put("Puerto Rico",170);
		ret.put("Guyana",171);
		ret.put("Santa Lucía",172);
		ret.put("Granada",173);
		ret.put("Moldavia",174);
		ret.put("Nepal",175);
		ret.put("Belice",176);
		ret.put("Camboya",177);
		ret.put("San Vicente y las Granadinas",178);
		ret.put("Montserrat",179);
		ret.put("Mauricio",180);
		ret.put("Chad",181);
		ret.put("Macao",182);
		ret.put("Mongolia",183);
		ret.put("Dominica",184);
		ret.put("Bután",185);
		ret.put("Santo Tomé y Príncipe",186);
		ret.put("Laos",187);
		ret.put("Samoa Estadounidense",188);
		ret.put("Islas Cook",189);
		ret.put("Brunéi Darussalam",190);
		ret.put("Samoa",191);
		ret.put("Bangladesh",192);
		ret.put("Yibuti",193);
		ret.put("Pakistán",194);
		ret.put("Islas Caimán",195);
		ret.put("Liechtenstein",196);
		ret.put("Tonga",197);
		ret.put("Timor Oriental",198);
		ret.put("Seychelles",199);
		ret.put("Eritrea",200);
		ret.put("Aruba",201);
		ret.put("Bahamas",202);
		ret.put("Somalia",203);
		ret.put("Gibraltar",204);
		ret.put("Guam",205);
		ret.put("Turcas y Caicos",206);
		ret.put("Sri Lanka",207);
		ret.put("Islas Vírgenes Estadounidenses",208);
		ret.put("Islas Vírgenes Británicas",209);
		ret.put("Anguila",210);
		ret.put("San Marino",211);
		return ret;
	}

}
