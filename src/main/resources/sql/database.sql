USE testing
CREATE TABLE [dbo].[pokemon](
	[pokemonId] [int] IDENTITY(1,1) NOT NULL,
	[pokemonDescription] [varchar](255) NULL,
	[pokemonImage] [varchar](255) NULL,
	[pokemonLikes] [int] NOT NULL,
	[pokemonName] [varchar](255) NULL,
	[pokemonType] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[pokemonId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[pokemon] ADD  CONSTRAINT [DF_SomeName]  DEFAULT ((0)) FOR [pokemonLikes]
GO

CREATE TABLE [dbo].[users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[email] [varchar](255) NULL,
	[password] [varchar](255) NULL,
	[username] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[role](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[users_roles](
	[AuthUser_id] [int] NOT NULL,
	[roles_id] [int] NOT NULL
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[users_roles]  WITH CHECK ADD  CONSTRAINT [FK15d410tj6juko0sq9k4km60xq] FOREIGN KEY([roles_id])
REFERENCES [dbo].[role] ([id])
GO

ALTER TABLE [dbo].[users_roles]  WITH CHECK ADD  CONSTRAINT [FKhh9s7l2sgg6dw39by1ygltcco] FOREIGN KEY([AuthUser_id])
REFERENCES [dbo].[users] ([id])
GO
