package client_server_data

class InitClass() {
    private val data = listOf(ArtistsTable, AlbumsTable, SongsTable, RolesTable, MembersTable, MembersAndRolesTable)

    fun getData() = data

    object ArtistsTable : Table {
        override val title: String = "Artists"
        override val createStmt: String = """
            CREATE TABLE $title (
                ID INTEGER PRIMARY KEY AUTOINCREMENT,
                Name VARCHAR(255)
            );
            """.trimIndent()

        override val fillStmt: String = """
           INSERT INTO $title (Name) VALUES
           ('Interpol'),
           ('Radiohead'),
           ('Tame Impala'); 
        """.trimIndent()
    }

    object AlbumsTable : Table {
        override val title: String = "Albums"
        override val createStmt: String = """
            CREATE TABLE $title (
              ID INTEGER PRIMARY KEY AUTOINCREMENT,
              AlbumTitle VARCHAR(255),
              ArtistID INTEGER,
              Year INTEGER,
              FOREIGN KEY (ArtistID) REFERENCES Artists(ID)
            );
        """.trimIndent()

        override val fillStmt: String = """
            INSERT INTO $title (AlbumTitle, ArtistId, Year) VALUES
            ('El Pintor', 1, 2014),
            ('Turn On the Bright Lights', 1, 2002),
            ('In Rainbows', 2, 2007),
            ('OK Computer', 2, 1997),
            ('Currents', 3, 2015),
            ('Lonerism', 3, 2012);
        """.trimIndent()

    }


    object SongsTable : Table {
        override val title: String = "Songs"
        override val createStmt: String = """
            CREATE TABLE $title (
               ID INTEGER PRIMARY KEY AUTOINCREMENT,
               SongTitle VARCHAR(255),
               Position INTEGER,
               AlbumID INTEGER,
               ArtistID INTEGER ,
               FOREIGN KEY (AlbumID) REFERENCES Albums(ID),
               FOREIGN KEY (ArtistID) REFERENCES Artists(ID)
            );
        """.trimIndent()

        override val fillStmt: String = """
            INSERT INTO $title (SongTitle, Position, AlbumID, ArtistID) VALUES
            ('All the Rage Back Home', 1, 1, 1),
            ('My Desire', 2, 1, 1),
            ('Anywhere', 3, 1, 1),
            ('Same Town, New Story', 4, 1, 1),
            ('My Blue Supreme', 5, 1, 1),
            ('Everything is Wrong', 6, 1, 1),
            ('Breaker 1', 7, 1, 1),
            ('Ancient Ways', 8, 1, 1),
            ('Tidal Wave', 9, 1, 1),
            ('Twice as Hard', 10, 1, 1),
            ('Untitled', 1, 2, 1),
            ('Obstacle 1', 2, 2, 1),
            ('NYC', 3, 2, 1),
            ('PDA', 4, 2, 1),
            ('Say Hello to the Angels', 5, 2, 1),
            ('Hands Away', 6, 2, 1),
            ('Obstacle 2', 7, 2, 1),
            ('Stella Was a Diver and She Was Always Down', 8, 2, 1),
            ('Roland', 9, 2, 1),
            ('The New', 10, 2, 1),
            ('Leif Erikson', 11, 2, 1),
            ('15 step', 1, 3, 2),
            ('Bodysnatchers', 2, 3, 2),
            ('Nude', 3, 3, 2),
            ('Weird Fishes/Arpeggi', 4, 3, 2),
            ('All I Need', 5, 3, 2),
            ('Faust Arp', 6, 3, 2),
            ('Reckoner', 7, 3, 2),
            ('House Of Cards', 8, 3, 2),
            ('Jigsaw Falling Into Place', 9, 3, 2),
            ('Videotape', 10, 3, 2),
            ('Airbag', 1, 4, 2),
            ('Paranoid Android', 2, 4, 2),
            ('Subterranean Homesick Alien', 3, 4, 2),
            ('Exit Music (For A Film)', 4, 4, 2),
            ('Let Down', 5, 4, 2),
            ('Karma Police', 6, 4, 2),
            ('Fitter Happier', 7, 4, 2),
            ('Electioneering', 8, 4, 2),
            ('Climbing Up The Walls', 9, 4, 2),
            ('No Surprises', 10, 4, 2),
            ('Lucky', 11, 4, 2),
            ('The Tourist', 12, 4, 2),
            ('Let It Happen', 1, 5, 3),
            ('Nangs', 2, 5, 3),
            ('The Moment', 3, 5, 3),
            ('Yes I''m Changing', 4, 5, 3),
            ('Eventually', 5, 5, 3),
            ('Gossip', 6, 5, 3),
            ('The Less I Know The Better', 7, 5, 3),
            ('Past Life', 8, 5, 3),
            ('Disciples', 9, 5, 3),
            ('''Cause I''m A Man', 10, 5, 3),
            ('Reality In Motion', 11, 5, 3),
            ('Love/Paranoia', 12, 5, 3),
            ('New Person, Same Old Mistakes', 13, 5, 3),
            ('Be Above It', 1, 6, 3),
            ('Endors Toi', 2, 6, 3),
            ('Apocalypse Dreams', 3, 6, 3),
            ('Mind Mischief', 4, 6, 3),
            ('Music to Walk Home By', 5, 6, 3),
            ('Why Won''t They Talk to Me?', 6, 6, 3),
            ('Feels Like We Only Go Backwards', 7, 6, 3),
            ('Keep On Lying', 8, 6, 3),
            ('Elephant', 9, 6, 3),
            ('She Just Won''t Believe Me', 10, 6, 3),
            ('Nothing That Has Happened So Far Has Been Anything We Could Control', 11, 6, 3),
            ('Sun''s Coming Up', 12, 6, 3);
        """.trimIndent()

    }

    object RolesTable : Table {
        override val title: String = "Roles"
        override val createStmt: String = """
            CREATE TABLE $title (
                ID INTEGER PRIMARY KEY AUTOINCREMENT,
                Role VARCHAR(255)
            );
        """.trimIndent()
        override val fillStmt: String = """
            INSERT INTO $title (Role) VALUES
            ('Lead Guitarist'),
            ('Rhythm Guitarist'),
            ('Bass Guitarist'),
            ('Drummer'),
            ('Vocals'),
            ('Back Vocals'),
            ('Synths/Effects'),
            ('Percussion'),
            ('Keyboards');
        """.trimIndent()

    }

    object MembersTable : Table {

        override val title: String = "Members"
        override val createStmt: String = """
            CREATE TABLE $title (
                ID INTEGER PRIMARY KEY AUTOINCREMENT,
                FirstName VARCHAR(255),
                LastName VARCHAR(255),
                ArtistID INTEGER,
                FOREIGN KEY (ArtistID) REFERENCES Artists(ID)
            );
        """.trimIndent()
        override val fillStmt: String = """
            INSERT INTO $title (FirstName, LastName, ArtistID) VALUES
            ('Paul', 'Banks', 1),
            ('Sam', 'Fogarino', 1),
            ('Daniel', 'Kessler', 1),
            ('Thom', 'Yorke', 2),
            ('Johny', 'Greenwood', 2),
            ('Colin', 'Greenwood', 2),
            ('Ed', 'O''Brien', 2),
            ('Philip', 'Selway', 2),
            ('Kevin', 'Parker', 3);
        """.trimIndent()

    }

    object MembersAndRolesTable : Table {
        override val title: String = "MembersAndRoles"
        override val createStmt: String = """
            CREATE TABLE $title (
              MemberID INTEGER,
              RoleID INTEGER,
              FOREIGN KEY (MemberID) REFERENCES Members(ID),
              FOREIGN KEY (RoleID) REFERENCES Roles(ID)
            );
        """.trimIndent()
        override val fillStmt: String = """
            INSERT INTO $title (MemberID, RoleID) VALUES
            (1, 2),
            (1, 5),
            (2, 4),
            (3, 1),
            (3, 6),
            (4, 5),
            (4, 2),
            (4, 9),
            (5, 1),
            (5, 9),
            (6, 3),
            (7, 2),
            (7, 6),
            (7, 7),
            (8, 4),
            (8, 8),
            (9, 1),
            (9, 2),
            (9, 3),
            (9, 4),
            (9, 5),
            (9, 6),
            (9, 7),
            (9, 8),
            (9, 9);
        """.trimIndent()
    }
}