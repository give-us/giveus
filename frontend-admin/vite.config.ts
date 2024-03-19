import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import tsConfigPaths from 'vite-tsconfig-paths'
import svgr from 'vite-plugin-svgr'
import mkcert from 'vite-plugin-mkcert'


// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react(), tsConfigPaths(), svgr(), mkcert()],
  server: {
    port: 3001,
    host: true,
    origin: 'http://0.0.0.0',
  },
})
