package model;

import java.io.Serializable;

public class Raza implements Serializable {
	private final String[] strRazasPerros = new String[] {
			"AFFENPINSCHER",
			"AFGANO",
			"AKITA",
			"ALANO",
			"AMERICAN_BULLY",
			"AMERICAN_FOXHOUND",
			"AMERICAN_PITBULL_TERRIER",
			"AMERICAN_STAFFORDSHIRE",
			"AUSTRALIAN_SILKY_TERRIER",
			"AZAWAKH",
			"BARBET",
			"BASENJI",
			"BASSET_ARTESIANO",
			"BASSET_GASCU�A",
			"BASSET_HOUND",
			"BEAGLE",
			"BERGER_PICARDIE",
			"BICH�N",
			"BILLY",
			"BLOODHOUND",
			"BOBTAIL",
			"BODEGUERO_ANDALUZ",
			"BOERBOEL",
			"BORDER_COLLIE",
			"BORDER_TERRIER",
			"BORZOI",
			"B�XER",
			"BRACO_ALEM�N",
			"BUHUND_NORUEGO",
			"BULL_TERRIER",
			"BULLDOG_AMERICANO",
			"BULLDOG_FRANC�S",
			"CANICHE",
			"CHIHUAHUA",
			"CHOW_CHOW",
			"COCKER",
			"COLLIE",
			"D�LMATA",
			"DOBERMAN",
			"DREVER",
			"FOX_TERRIER",
			"FOXHOUND",
			"GALGO",
			"GOLDEN_RETRIEVER",
			"GRIF�N",
			"HARRIER",
			"H�BRIDO",
			"HOKKAIDO",
			"HOVAWART",
			"HUSKY_SIBERIANO",
			"KOREA_JINCO",
			"KUVASZ",
			"KROMFOHRL�NDER",
			"KOMONDOR",
			"KISHU",
			"KEEDHOND",
			"LABRADOR_RETRIEVER",
			"LA�KA_SIBERIANO",
			"LA�KA_RUSO_EUROPEO",
			"LAKELAND_TERRIER",
			"LANDSEER",
			"LEONBERGER",
			"LUNDEHUND",
			"MALAMUTE",
			"MAST�N",
			"MUDI",
			"M�NSTERL�NDER",
			"PAPILLON",
			"PARSON_RUSSELL_TERRIER",
			"PASTOR_ALEM�N",
			"PASTOR_BELGA",
			"PASTOR_BLANCO_SUIZO",
			"PASTOR_AUSTRALIANO",
			"PASTOR_CATAL�N",
			"PASTOR_ANATOLIA",
			"PASTOR_BEAUCE",
			"PASTOR_PIRINEOS",
			"PASTOR_SHETLAND",
			"PASTOR_POLACO",
			"PEQUIN�S",
			"PINSCHER",
			"PLOTT_HOUND",
			"POINTER",
			"POITEVIN",
			"POMERANIA",
			"PORCELAINE",
			"PUDELPOINTER",
			"PULI",
			"PUMI",
			"RIDGEBACK_RODESIA",
			"ROTTWEILER",
			"SABUESO_ALEM�N",
			"SABUESO_ARTESIANO",
			"SABUESO",
			"SAN_BERNARDO",
			"SCHNAUZER",
			"SETTER",
			"SHIBA",
			"SHIHTZU",
			"SILKY_TERRIER",
			"SHIKOKU",
			"SPITZ",
			"STAFFORDSHIRE",
			"TECKEL",
			"TEJONERO",
			"TERRANOVA",
			"TERRIER",
			"VALHUND_SUECO",
			"VOLPINO_ITALIANO",
			"WETTERHOUND",
			"WHIPPET",
			"WOLFHOUND_IRLAND�S",
			"YORKSHIRE_TERRIER"
			
	};
	private final String[] strRazasGatos = new String[] {
			"WIREHAIR_AMERICANO",
			"KHANO_MANEE",
			"ORIENTAL_PELOLARGO",
			"RAB�N_JAPON�S",
			"SILVESTRE_BOSQUE_NORUEGA",
			"TONQUIN�S",
			"ABISINIOS",
			"CURL_AMERICANO",
			"SHORTHAIR_AMERICANO",
			"RUSO_AZUL",
			"BALINES",
			"BENGAL�",
			"BOBTAIL_JAPON�S",
			"BOMBAY",
			"SHORTHAIR_BRIT�NICO",
			"BURMILLA",
			"SPANGLED_CALIFORNIANO",
			"CHARTREAUX",
			"EUROPEO_COM�N",
			"CORNISH_RED",
			"CYMRIC",
			"DEVON_REX",
			"EX�TICO",
			"FOLDEX",
			"GERMAN_REX",
			"HABANA",
			"HIGHLAND_FOLD",
			"HIMALAYO",
			"JAVAN�S",
			"KORAT",
			"MAINE_COON",
			"MANX",
			"MAU_EGIPCIO",
			"MUNCHKIN",
			"NEBELUNG",
			"OCICAT",
			"PETERBALD",
			"PIXIE_BOB",
			"RAGAMUFFIN",
			"RAGDOLL",
			"SAGRADO_BIRMANIA",
			"SCOTTISH_FOLD",
			"SERENGUETI",
			"SEYCHELLOIS",
			"SIBERIANO",
			"SINGAPURA",
			"SKOGKATT",
			"SHOWSHOE",
			"SOKOKE",
			"SPHYNX",
			"THAI",
			"VAN_TURCO",
			"YORK_CHOCOLATE",
			"BURM�S"
			
	};
	
	public String get_perro(int ordinal)
	{
		return strRazasPerros[ordinal];
	}
	
	public String get_gato(int ordinal)
	{
		return strRazasGatos[ordinal];
	}
}
